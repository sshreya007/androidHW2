package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListActivity2 : AppCompatActivity() {
    lateinit var listView: ListView
    val contacts = arrayOf(
        "Ram","Shyam","Hari","Gita","Sita",
        "Ram","Shyam","Hari","Gita","Sita",
        "Ram","Shyam","Hari","Gita","Sita")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list2)
        listView=findViewById(R.id.ListView)

        var adapter = ArrayAdapter(
            this@ListActivity2,
            android.R.layout.simple_list_item_1,
            contacts
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->

            if (parent !=null){
                Toast.makeText(
                    this@ListActivity2,
                            parent.getItemAtPosition(position).toString(),
                            Toast.LENGTH_SHORT
                ).show()
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.outputPassword)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}