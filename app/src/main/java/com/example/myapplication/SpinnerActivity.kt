package com.example.myapplication

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpinnerActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener{
    lateinit var spinner: Spinner
    lateinit var textView: TextView
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var datetext :EditText

    val countries = arrayOf("Nepal","india","china","japan","canada")

    val cities=arrayOf("Kathmandu","Bhaktapur","Lalitpur","Kirtipur","Kanchanpur")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_spinner)
        spinner=findViewById(R.id.spinner)
        textView=findViewById(R.id.textView3)
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView)
        datetext = findViewById(R.id.editTextDate)

        datetext.isFocusable =false
        datetext.isClickable = true


        datetext.setOnClickListener{
            loadCalendar()
        }

        var autoAdapter=ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_spinner_dropdown_item,cities

        )
        autoCompleteTextView.setAdapter(autoAdapter)
        autoCompleteTextView.threshold =1

        val adapter =ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_spinner_item,
            countries
        )
            adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )
        spinner.adapter = adapter

        spinner.onItemSelectedListener =this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.outputPassword)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val days =c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(
            this@SpinnerActivity,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                datetext.setText("$year/${month+1}/$days")
            },year,month,days
        )
        dialog.show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(parent !=null){
            textView.text =parent.getItemAtPosition(position).toString()
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}