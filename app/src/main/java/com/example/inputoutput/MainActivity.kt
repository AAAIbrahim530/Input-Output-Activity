package com.example.inputoutput

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    enum class Languages {
        ENGLISH,
        NDEBELE,
        PEDI,
        SOTHO,
        SWATI,
        TSONGA,
        TSWANA,
        VENDA,
        XHOSA,
        ZULU,
        AFRIKAANS
    }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val clickmebtn = findViewById<Button>(R.id.Click)
        val welcomeTxt = findViewById<TextView>(R.id.Welcome)
        val nameTxtField = findViewById<EditText>(R.id.editText)
        val zuluSwitch = findViewById<Switch>(R.id.zuluswitch)
        val languagespinner = findViewById<Spinner>(R.id.Spinner)
        languagespinner.adapter = ArrayAdapter<MainActivity.Languages>(this,
            android.R.layout.simple_list_item_1, Languages.values())
        clickmebtn?.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Button clicked", Toast.LENGTH_LONG
            ).show()
            welcomeTxt.text = "Welcome, ${nameTxtField.text}!"
        }


        clickmebtn?.setOnClickListener {
            var hello: String = ""
            var zulu: Boolean = zuluSwitch.isChecked
            var age: Int = 20
            var language = languagespinner.selectedItem as Languages
            when(language) {
                Languages.ZULU -> hello = "molo, $nameTxtField"
                else -> hello = "hello, $nameTxtField"
            }
//            if (zulu) {
//                hello = "molo, ${nameTxtField.text}!"
//            } else {
//                hello = "hello, ${nameTxtField.text}!"
//
//                if ((nameTxtField.text.toString() =="Sam" ||
//                    nameTxtField.text.toString() == "Samantha")
//                    && age > 20) {
//                    hello = "Hey, ${nameTxtField.text}!"
//                } else{
//                    hello = "hello, ${nameTxtField.text}!"
//                }
//            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}