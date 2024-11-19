package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AssignmentActivity : AppCompatActivity() {
    lateinit var editTextHeading1: EditText
    lateinit var editTextHeading2: EditText
    lateinit var editTextHeading3: EditText
    lateinit var buttonSignup: Button
    lateinit var textViewFirstName: TextView
    lateinit var textViewLastName: TextView
    lateinit var textViewEmail: TextView
    lateinit var textViewPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_assignment)
        editTextHeading1 = findViewById(R.id.heading1)
        editTextHeading2 = findViewById(R.id.heading2)
        editTextHeading3 = findViewById(R.id.heading3)
        buttonSignup = findViewById(R.id.buttonsignup)
        textViewFirstName = findViewById(R.id.firstname)
        textViewLastName = findViewById(R.id.lastname)
        textViewEmail = findViewById(R.id.email)
        textViewPassword = findViewById(R.id.password)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}