package com.tech.kidsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.random.Random

class MultiplicationActivity : AppCompatActivity() {


    lateinit var score: TextView
    lateinit var life: TextView
    lateinit var time: TextView
    lateinit var question: TextView
    lateinit var answer: EditText

    lateinit var buttonOK: Button
    lateinit var buttonNext: Button

    var correctAns=0;
    var userScore=0;
    var userLife=3;

    lateinit var timer : CountDownTimer
    private val startTimerInMillis : Long=30000
    var timeLeftInMillis :Long=startTimerInMillis
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplication)
        supportActionBar!!.title = "Multiplication"

        score = findViewById(R.id.score)
        life = findViewById(R.id.life)
        time = findViewById(R.id.time)
        question = findViewById(R.id.question)
        answer = findViewById(R.id.answer)
        buttonOK = findViewById(R.id.ok)
        buttonNext = findViewById(R.id.next)

        gameContinue()

        buttonOK.setOnClickListener {

            buttonOK.isEnabled=false
            buttonNext.isEnabled=true

            val input = answer.text.toString()
            if (input == "") {
                Toast.makeText(
                    applicationContext,
                    "please write an answer or click next button",
                    Toast.LENGTH_SHORT
                ).show()

                buttonOK.isEnabled=true
                buttonNext.isEnabled=false

            } else {

                pauseTimer()

                val userans = input.toInt()
                if (userans == correctAns) {
                    userScore += 10;
                    question.text = "Congratulations your answer is correct......."
                    score.text = userScore.toString()

                } else {
                    userLife--;
                    question.text = "Sorry, your answer is wrong"
                    life.text = userLife.toString()
                }


            }

        }

        buttonNext.setOnClickListener {
            buttonOK.isEnabled=true

            pauseTimer()
            resetTimer()

          //  gameContinue()
            answer.setText("")

            if(userLife==0)
            {
                Toast.makeText(applicationContext,"GameOver", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MultiplicationActivity,ResultActivity::class.java)

                intent.putExtra("score",userScore)
                startActivity(intent)
                finish()
            }
            else
            {
                gameContinue()
            }

        }
    }

    //function to run game
    fun gameContinue()
    {
        buttonNext.isEnabled=false

        val num1= Random.nextInt(0,100)
        val num2= Random.nextInt(0,100)

        question.text = "$num1 * $num2"
        correctAns=num1*num2

        startTimer()


    }

    fun startTimer()
    {
        timer=object :CountDownTimer(timeLeftInMillis,1000)
        {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis=millisUntilFinished
                updateText()
            }

            override fun onFinish() {
                pauseTimer()
                resetTimer()
                updateText()

                userLife--;
                life.text=userLife.toString()
                question.text="Sorry, Time is up!!"
            }

        }.start()
    }

    fun updateText()
    {
        val remainingTime : Int = (timeLeftInMillis/1000).toInt()
        //time.text = remainingTime.toString()

        time.text = String.format(Locale.getDefault(),"%02d",remainingTime)
    }

    fun pauseTimer()
    {
        timer.cancel()
    }

    fun resetTimer()
    {
        timer.cancel()
        timeLeftInMillis=startTimerInMillis
        updateText()
    }
}