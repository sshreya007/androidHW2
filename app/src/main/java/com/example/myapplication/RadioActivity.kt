//package com.example.myapplication
//
//import android.os.Bundle
//import android.widget.ImageView
//import android.widget.RadioButton
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
//class RadioActivity : AppCompatActivity() {
//    lateinit var radioCherry : RadioButton
//    lateinit var radioOrange : RadioButton
//    lateinit var radioFruits : RadioButton
//    lateinit var imageViewRadioButton:ImageView
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_radio)
//
//        radioCherry = findViewById(R.id.btncherry)
//        radioFruits = findViewById(R.id.btnfruits)
//        radioOrange = findViewById(R.id.btnorange)
//
//        imageViewRadioButton = findViewById(R.id.imageView4)

//        radioCherry.set
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}