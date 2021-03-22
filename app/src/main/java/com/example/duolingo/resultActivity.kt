package com.example.duolingo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username=intent.getStringExtra(Constants.USER_NAME)
        userName.text=username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        score.text="Your score is $correctAnswers out of $totalQuestions"
        finishButton.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}