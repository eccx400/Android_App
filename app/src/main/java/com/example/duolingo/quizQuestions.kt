package com.example.duolingo

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class quizQuestions : AppCompatActivity(), View.OnClickListener {

    private var myCurrentPos:Int = 1
    private var myQuestionsList: ArrayList<Question> ?= null
    private var mySelectedPos:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        myQuestionsList = Constants.getQuestions()

        setQuestion()

        option_One.setOnClickListener(this)
        option_Two.setOnClickListener(this)
        option_Three.setOnClickListener(this)
        option_Four.setOnClickListener(this)
        submitButton.setOnClickListener(this)
    }

    private fun setQuestion(){
        myCurrentPos = 1
        val question = myQuestionsList!![myCurrentPos - 1]

        defaultOptionsView()

        progressBar.progress = myCurrentPos
        qProgress.text = "$myCurrentPos" + "/" + progressBar.max

        mainQuestion.text = question!!.question
        mainImage.setImageResource(question.image)
        option_One.text = question.optionOne
        option_Two.text = question.optionTwo
        option_Three.text = question.optionThree
        option_Four.text = question.optionFour
    }

    private fun defaultOptionsView()
    {
        val options=ArrayList<TextView>()
        options.add(0, option_One)
        options.add(1, option_Two)
        options.add(2, option_Three)
        options.add(3, option_Four)

        for(option in options){
            option.setTextColor(Color.parseColor("#363A43"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv:TextView, selectedNum: Int)
    {
        defaultOptionsView()
        mySelectedPos = selectedNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.default_option_border_bg)
    }

    private fun answerView(answer: Int, drawView: Int){
        when(answer)
    }

    override fun onClick(v: View?){
        when(v?.id){
            R.id.option_One ->{
                selectedOptionView(option_One,1)
            }
            R.id.option_Two ->{
                selectedOptionView(option_Two,2 )
            }
            R.id.option_Three ->{
                selectedOptionView(option_Three,3)
            }
            R.id.option_Four ->{
                selectedOptionView(option_Four,4)
            }
            R.id.submitButton ->{
                if(mySelectedPos==0)
                {
                    myCurrentPos++

                    when{
                    myCurrentPos <= myQuestionsList!!.size ->{
                            setQuestion()
                        }
                        else ->{
                            val intent= Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, username)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, myQuestionsList!!.size)
                            startActivity(intent)
                            finish()

                        }
                    }
                }else
                {
                    val question = myQuestionsList?.get(myCurrentPos - 1)
                    if(question!!.correctAnswers != myCurrentPos)
                    {
                        answerView(mySelectedPos,R.drawable.incorrect_option_border_bg)
                    }
                    else
                    {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswers,R.drawable.correct_option_border_bg)

                    if(myCurrentPos == myQuestionsList!!.size)
                    {
                        submitButton.text="FINISH"

                    }
                    else
                    {
                        submitButton.text="Go to the next question"
                    }
                    mySelectedPos=0
                }
            }
        }
    }
}