package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {
    lateinit var binding: ActivityButtonBinding

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityButtonBinding.inflate(layoutInflater)

        setContentView(binding.root)

        sharedPreferences=getSharedPreferences("user", Context.MODE_PRIVATE)

        binding.btnNavigate.setOnClickListener {
            val username: String = binding.textName.text.toString()
            val password: String = binding.textPassword.text.toString()

            if (username.isEmpty()) {
                binding.textName.error = "Username can't be empty"

            } else if (password.isEmpty()) {
                binding.textPassword.error = "Password can't be empty"
            } else {
                if(binding.rememberMe.isChecked){
                    val editor = sharedPreferences.edit()
                    editor.putString("username",username)
                    editor.putString("password",password)
                    editor.apply()
                }
                var intent = Intent(
                    this@ButtonActivity,
                    DestinationActivity::class.java
                )
                intent.putExtra("username", username)
                intent.putExtra("password", password)

                startActivity(intent)
            }


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.outputPassword)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}