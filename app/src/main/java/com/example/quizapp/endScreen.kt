package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class endScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_screen)

        MobileAds.initialize(this@endScreen)
        val adRequest= AdRequest.Builder().build()
        findViewById<AdView>(R.id.endAd).loadAd(adRequest)

        val fname=intent.getStringExtra(Data.usr_name).toString()
        val fscore= intent.getStringExtra(Data.score).toString()
        findViewById<TextView>(R.id.usr).text=fname
        findViewById<TextView>(R.id.score).text="$fscore/5"
    }

    fun Restart(view: View) {
        val res=Intent(this, MainActivity::class.java)
        startActivity(res)
        finish()
    }
}