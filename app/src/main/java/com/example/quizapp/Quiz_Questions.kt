package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class Quiz_Questions : AppCompatActivity(), View.OnClickListener {
    var currentPosition=1
    var selectedPosition=0
    val QuesList=Data.getQues()
    var score:Int=0
    var name: String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        setQuestion()
        findViewById<TextView>(R.id.op1).setOnClickListener(this)
        findViewById<TextView>(R.id.op2).setOnClickListener(this)
        findViewById<TextView>(R.id.op3).setOnClickListener(this)
        findViewById<TextView>(R.id.op4).setOnClickListener(this)
        findViewById<Button>(R.id.btn).setOnClickListener(this)
        name=intent.getStringExtra(Data.usr_name)

    }
    fun setQuestion() {
        val ques: Questions?=QuesList[currentPosition-1]
        defaultOption()
        findViewById<ProgressBar>(R.id.prog).progress=currentPosition
        findViewById<TextView>(R.id.ques).text=ques!!.que
        findViewById<TextView>(R.id.op1).text=ques!!.op1
        findViewById<TextView>(R.id.op2).text=ques!!.op2
        findViewById<TextView>(R.id.op3).text=ques!!.op3
        findViewById<TextView>(R.id.op4).text=ques!!.op4

    }
    fun defaultOption() {
        val options=ArrayList<TextView>()
        options.add(0,findViewById(R.id.op1))
        options.add(1,findViewById(R.id.op2))
        options.add(2,findViewById(R.id.op3))
        options.add(3,findViewById(R.id.op4))

        for(option in options)
        {
            option.setTextColor(Color.parseColor("#323232"))
            option.background=ContextCompat.getDrawable(this, R.drawable.default_option)
            option.typeface= Typeface.DEFAULT
        }
    }
    fun selectedOption(tv: TextView, selectedOptionNum: Int) {
        defaultOption()
        selectedPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.background=ContextCompat.getDrawable(this, R.drawable.selected_option)
        tv.setTypeface(tv.typeface, Typeface.BOLD)
    }
    fun answerView(answer: Int, action: Int) {
        when(answer) {
            1 -> {findViewById<TextView>(R.id.op1).background=ContextCompat.getDrawable(this, action)}
            2 -> {findViewById<TextView>(R.id.op2).background=ContextCompat.getDrawable(this, action)}
            3 -> {findViewById<TextView>(R.id.op3).background=ContextCompat.getDrawable(this, action)}
            4 -> {findViewById<TextView>(R.id.op4).background=ContextCompat.getDrawable(this, action)}
        }
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.op1 -> {selectedOption(findViewById(R.id.op1), 1)}
            R.id.op2 -> {selectedOption(findViewById(R.id.op2), 2)}
            R.id.op3 -> {selectedOption(findViewById(R.id.op3), 3)}
            R.id.op4 -> {selectedOption(findViewById(R.id.op4), 4)}
            R.id.btn -> {
                if(selectedPosition==0) {
                    currentPosition++
                    when {
                        (currentPosition<=QuesList!!.size) -> {
                            findViewById<Button>(R.id.btn).text = "Submit"
                            setQuestion()}
                        else -> {
                            val intent=Intent(this, endScreen::class.java)
                            intent.putExtra(Data.score, score.toString())
                            intent.putExtra(Data.usr_name, name)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else {
                    val ques=QuesList?.get(currentPosition-1)
                    if(selectedPosition==ques.correct) {
                        answerView(selectedPosition, R.drawable.correct_option)
                        score++
                    }
                    else {
                        answerView(selectedPosition, R.drawable.incorrect_option)
                        answerView(ques.correct, R.drawable.correct_option)
                    }
                    selectedPosition=0
                    findViewById<Button>(R.id.btn).text = "Next Question"
                }
            }
        }
    }
}