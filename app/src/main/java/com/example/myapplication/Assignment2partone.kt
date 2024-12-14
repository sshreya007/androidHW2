package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.MultiAutoCompleteTextView
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Assignment2partone : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var username: TextView
    lateinit var email: TextView
    lateinit var imageView: ImageView
    lateinit var password: EditText
    lateinit var gender: TextView
    lateinit var male: RadioButton
    lateinit var female: RadioButton
    lateinit var country: Spinner
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var agreeCheckButton: CheckBox
    lateinit var submitButton: Button


    val countries = arrayOf("Nepal", "india", "china", "japan", "canada")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_assignment2partone)

        username = findViewById(R.id.usernameA)
        email = findViewById(R.id.emailA)
        password = findViewById(R.id.passwordA)
        gender = findViewById(R.id.genderA)
        male = findViewById(R.id.radioButtonMale)
        female = findViewById(R.id.radioButtonFemale)
        country = findViewById(R.id.spinner)
        autoCompleteTextView = findViewById(R.id.selectedCountry)
        agreeCheckButton = findViewById(R.id.checkBoxAgree)
        submitButton = findViewById(R.id.buttonSubmit)

        val adapter = ArrayAdapter(
            this@Assignment2partone,
            android.R.layout.simple_spinner_item,
            countries
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        country.adapter = adapter

        country.onItemSelectedListener = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.genderA)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {
            username.text = parent.getItemAtPosition(position).toString()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }
        submitButton.setOnClickListener {
            if (!agreeCheckButton.isChecked) {
                Toast.makeText(this, "Please agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            } else {
                val username = username.text.toString()
                val email = email.text.toString()
                val password = password.text.toString()
                val gender = if (male.isChecked) "Male" else "Female"
                val country = country.selectedItem.toString()

                // Show success message or process the input data
                Toast.makeText(this, "Submitted!\nUsername: $username\nEmail: $email\nGender: $gender\nCountry: $country", Toast.LENGTH_LONG).show()
            }
        }
    }
}