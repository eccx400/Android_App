package com.example.duolingo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

object Constants{
    const val USER_NAME: String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS: String="correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList=ArrayList<Question>()
        val question1 = Question(
            1,"What sound does this make?",
            R.drawable.nihao,
            "nihao","zaijian",
            "zaoan","huijia",1)
        questionsList.add(question1)

        val question2 = Question(
            2, "How do you say?",
            R.drawable.at,
            "maltid", "piger",
            "klokken", "canar", 3
        )
        questionsList.add(question2)

        // 3
        val question3 = Question(
            3, "What sound does this make?",
            R.drawable.gal,
            "yeo", "sul",
            "gam", "gal", 4
        )

        questionsList.add(question3)
        // 4
        val que4 = Question(
            4, "Choose this sentence in English.",
            R.drawable.wna,
            "Apple and Toast", "Water and Apple",
            "I eat apple", "Drink the Water", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What sound does this make?",
            R.drawable.chi,
            "yo", "mu",
            "chi", "tsu", 3
        )

        questionsList.add(que5)
        return questionsList
    }
}