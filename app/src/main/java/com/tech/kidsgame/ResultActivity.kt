package com.tech.kidsgame

import android.app.AlertDialog
import android.app.Dialog
import android.app.Dialog.*
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    lateinit var playagain : Button
    lateinit var exit:Button
    lateinit var result : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        playagain= findViewById(R.id.playagain)
        exit=findViewById(R.id.exit)
        result =findViewById(R.id.finalScore)

        val score = intent.getIntExtra("score",0)
        result.text="Your Score : "+score
        playagain.setOnClickListener {

            intent = Intent(this@ResultActivity,MainActivity::class.java)
            startActivity(intent)

            finish()
        }
        exit.setOnClickListener {


            var alertDialog = AlertDialog.Builder(this@ResultActivity)
            alertDialog.setTitle("EXIT")
                .setMessage("Do you want to exit")

                .setCancelable(false)
                .setNegativeButton("NO", DialogInterface.OnClickListener { dialogInterface, which ->
                    dialogInterface.cancel()
                })
                .setPositiveButton("yes", DialogInterface.OnClickListener { dialogInterface, which ->
                    val intent = Intent(Intent.ACTION_MAIN)
                    intent.addCategory(Intent.CATEGORY_HOME)
                    intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    //   exitProcess(0)
                })

            alertDialog.create().show()




        }
    }
}