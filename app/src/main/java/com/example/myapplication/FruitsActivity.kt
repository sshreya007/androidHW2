package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.FruitsAdapter

class FruitsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    val imageList =ArrayList<Int>()
    val nameList =ArrayList<String>()
    val descList =ArrayList<String>()

    lateinit var adapter: FruitsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fruits)
        recyclerView =findViewById(R.id.RecyclerView)

        imageList.add(R.drawable.ora)
        imageList.add(R.drawable.cherrie)
        imageList.add(R.drawable.fruits)

        nameList.add("Orange")
        nameList.add("Cherrie")
        nameList.add("Fruits")

        descList.add("This is orrange")
        descList.add("This is Cherrie")
        descList.add("This is Fruits")

        adapter = FruitsAdapter(
            this@FruitsActivity,
            imageList,nameList,descList

        )

        recyclerView.adapter=adapter

//        recyclerView.layoutManager=LinearLayoutManager(this@FruitsActivity)-for vertical
//        recyclerView.layoutManager=LinearLayoutManager(this@FruitsActivity,LinearLayoutManager.HORIZONTAL,false)-for horizontal

        //grid:
        recyclerView.layoutManager=GridLayoutManager(this@FruitsActivity,2)






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.outputPassword)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}