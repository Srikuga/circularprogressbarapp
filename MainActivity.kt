package com.example.circularprogressbarapp

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.parseInt
import java.util.concurrent.Executor



class MainActivity : AppCompatActivity() {


    val myHandler : Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.progress_circular)

        var input_progress = findViewById<EditText>(R.id.input_time)

       val btndone = findViewById<Button>(R.id.btn_done)



        checkMyProgress.setOnClickListener {
            var myprogress = input_progress.text.toString()
            var delay = myprogress.toLong()

            if (delay>0) {
                Thread(Runnable {
                    while (progress_circular.progress < 100) {

                        progress_circular.progress += 1
                        myHandler.post {
                            // progressBar.progress = progress_circular.progress
                            progress_view.text = progress_circular.progress.toString() + "%"
                        }

                        try {
                            Thread.sleep(160 + delay)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                    }


                }).start()
                //txtviewdone.visibility= VISIBLE

            }
            else
            {
                Toast.makeText(
                    applicationContext,
                    "You have to give weight of your task",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }

        btn_done.setOnClickListener {
            progressBar.progress = 0
            progress_view.text=progress_circular.progress.toString() + "%"

        }





/*


        increaseBar.setOnClickListener {

            progressBar.progress += 10
            progress_view.text = "${progressBar.progress}/${progressBar.max}"
            //modifyProgressBar(10)
        }
        decreaseBar.setOnClickListener {
            progressBar.progress += -10
            progress_view.text = "${progressBar.progress}/${progressBar.max}"
            //modifyProgressBar(-10)
        }*/
       // progressBar.max = 100
        //progressBar.progress = 50

    }
}




