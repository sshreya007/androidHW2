package com.example.myapplication

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class InteractionActivity : AppCompatActivity() {
    lateinit var btnSnack: Button
    lateinit var  btnAlert:Button
    lateinit var  btnToast:Button
    lateinit var main: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_interaction)

        main = findViewById(R.id.outputPassword)
        btnSnack =findViewById(R.id.btnSnack)
        btnAlert =findViewById(R.id.btnAlert)
        btnToast =findViewById(R.id.btnToast)


        btnToast.setOnClickListener{
            Toast.makeText(this@InteractionActivity,"Login Success",Toast.LENGTH_LONG) .show()
        }
        btnAlert.setOnClickListener{
            var alert =AlertDialog.Builder(this@InteractionActivity)
            alert.setTitle("Confirmation")
            alert.setMessage("Are You sure?")
            alert.setIcon(R.drawable.ora)
            alert.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i->
                dialogInterface.dismiss()
            })
            alert.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i->  })

            alert.create().show()
        }

        btnSnack.setOnClickListener{
            Snackbar.make(main, "Invalid Login",
                Snackbar.LENGTH_LONG).setAction("close",{}).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.outputPassword)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}