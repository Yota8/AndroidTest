package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class FirstActivity : AppCompatActivity() {

        private val backLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data?.getStringExtra("data_return")
                Log.d("FirstActivity", "the message is $data")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)

        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            /*val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.baidu.com")
            startActivity(intent)*/

            /*val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)*/

            /*val data = "Hello 2_activity"
            val intent = Intent(this, SecondLayoutActivity::class.java)
            intent.putExtra("Extra data",data)
            startActivity(intent)*/

            val intent = Intent(this, SecondLayoutActivity::class.java)
            backLauncher.launch(intent)
        }

        val button_jump: Button = findViewById(R.id.button_jump)
        button_jump.setOnClickListener {
            val intent = Intent(this, SecondLayoutActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "add_item", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "remove_item", Toast.LENGTH_SHORT).show()
            R.id.query_item -> Toast.makeText(this, "query_item", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    /*
    * 下面这种方法已经被弃用了，现在用的是 Activity Result API*/

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            0 -> if (resultCode == RESULT_OK) {
                val returndata = data?.getStringExtra("data_return")
                Log.d("FirstActivity", "returned data is $returndata")
            }
        }
    }*/

}

