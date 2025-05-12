package com.example.smartspend

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_welcome_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.WelcomePage)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        navigateOnClick(R.id.sign_in_btn, SignIn::class.java)
        navigateOnClick(R.id.sign_up_btn, SignUpPage::class.java)

    }
    private fun navigateOnClick(buttonId: Int, destination: Class<*>) {
        val button = findViewById<Button>(buttonId)
        button.setOnClickListener {
            val intent = Intent(this, destination)
            startActivity(intent)
        }
    }

}