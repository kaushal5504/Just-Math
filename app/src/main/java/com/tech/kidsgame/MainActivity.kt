package com.tech.kidsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var addition: Button
    lateinit var subtraction: Button
    lateinit var multiplication: Button
    lateinit var division: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addition=findViewById(R.id.add)
        subtraction=findViewById(R.id.subtract)
        multiplication=findViewById(R.id.multiply)
        division=findViewById(R.id.divide)


        addition.setOnClickListener {
            val intent = Intent(this@MainActivity,AdditionActivity::class.java)
            startActivity(intent)
        }
        subtraction.setOnClickListener {
            val intent = Intent(this@MainActivity,SubtractionActivity::class.java)
            startActivity(intent)
        }
        multiplication.setOnClickListener {
            val intent = Intent(this@MainActivity,MultiplicationActivity::class.java)
            startActivity(intent)

        }
        division.setOnClickListener {
            val intent = Intent(this@MainActivity,DivisionActivity::class.java)
            startActivity(intent)
        }
    }
}