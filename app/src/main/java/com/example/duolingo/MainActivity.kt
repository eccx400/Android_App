package com.example.duolingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.provider.SyncStateContract
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        startbutton.setOnClickListener {

            if (username.text.toString().isEmpty())
            {
                Toast.makeText(this,"Please enter your name!", Toast.LENGTH_SHORT).show()

            }
            else
            {
                val intent= Intent(this,quizQuestions::class.java)
                intent.putExtra(Constants.USER_NAME,username.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}