package com.example.activitytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class SecondLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        val button_jumped:Button = findViewById(R.id.button_jumped)
        button_jumped.setOnClickListener {
            // Toast.makeText(this, "is jumped.",Toast.LENGTH_SHORT).show()
            val intent = Intent()
            intent.putExtra("data_return", "this is SecondActivity")
            setResult(RESULT_OK, intent)
            finish()
        }

        val button_jumpback:Button = findViewById(R.id.button_jumpback)
        button_jumpback.setOnClickListener {
            Toast.makeText(this, "jumpping back.",Toast.LENGTH_SHORT).show()
            val intent_back = Intent(this, FirstActivity::class.java)
            startActivity(intent_back)
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return", "this is Second's Back Button")
        setResult(RESULT_OK, intent)
        finish()
    }
}