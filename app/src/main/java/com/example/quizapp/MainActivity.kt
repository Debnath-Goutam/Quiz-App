package com.example.quizapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this@MainActivity)
        val adRequest=AdRequest.Builder().build()
        findViewById<AdView>(R.id.adview).loadAd(adRequest)

        val btn_start=findViewById<Button>(R.id.btn_start)
        btn_start.setOnClickListener {
            if(findViewById<EditText>(R.id.name).text.toString().isEmpty())
               Toast.makeText(this,"Please enter your name", Toast.LENGTH_SHORT).show()
            else {
                var intent = Intent(this, Quiz_Questions::class.java)
                intent.putExtra(Data.usr_name, findViewById<EditText>(R.id.name).text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}