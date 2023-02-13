package com.tech.kidsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Thread.sleep


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        class myThread :Thread()
        {
           public override fun run()
            {
                try{

                    sleep(3000)

                }
                catch(e : Exception)
                {
                    e.stackTrace
                }
                finally{

                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)

                }
            }
        }
        var newThread =myThread()
        newThread.start()


    }
}