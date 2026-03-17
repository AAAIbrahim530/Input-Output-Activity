package com.example.inputoutput

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val clickmebtn = findViewById<Button>(R.id.Click)
        val welcomeTxt = findViewById<TextView>(R.id.Welcome)
        val nameTxtField = findViewById<EditText>(R.id.editText)
        clickmebtn?.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Button clicked", Toast.LENGTH_LONG
            ).show()
            welcomeTxt.text = "Welcome, ${nameTxtField.text}!"
        }
        val zuluSwitch = findViewById<Switch>(R.id.zuluswitch)

        clickmebtn?.setOnClickListener {
            var hello: String
            if (zuluSwitch.isChecked) {
                hello = "molo, ${nameTxtField.text}!"
            } else {
                hello = "hello, ${nameTxtField.text}!"

                if (nameTxtField.text.toString() =="Sam")
                    hello="Hey, ${nameTxtField.text}!"
                else
                    hello = "hello, ${nameTxtField.text}"
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}