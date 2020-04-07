package com.example.class501

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.class501.R
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPing.setOnClickListener{
            Thread (Runnable {
                ping(etIP.text.toString())
            }).start()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun ping(ip: String) {
        val process = Runtime.getRuntime().exec("ping -c 8 $ip")
        val bufferedReader = BufferedReader(InputStreamReader(process.inputStream))
        val builder = StringBuilder()
        for (line in bufferedReader.lines()) {
            builder.append(line)
            builder.append("\n")
        }
        runOnUiThread {
            tvResult.text = builder.toString()
        }
    }
}
//git config --global user.email "ryanesr9007@gmail.com" git config --global user.name "Richard Yanes"