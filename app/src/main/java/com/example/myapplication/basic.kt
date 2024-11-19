package com.example.myapplication

fun main(){
    println("Hello World")
    var name : String ="Shreya"
    var age : Int = 18
    println("My name is $name and my age us $age")
    println("My name is {name uppercase()}")

    var data1 =arrayOf("shreya","riya","simran")
    println("1st element is ${data1[0]}")
    println("2nd element is ${data1[1]}")
    println("3rdelement is ${data1[2]}")

   // println("Enter any word")
    //var input : String =readln()
    //println(dictionary[input])//

    println("Enter day of week")
    var dayOfWeek : Int = readln().toInt()
    var day : String

    when(dayOfWeek){
        1->"Sunday"
        2->"Monday"
        3->"Tuesday"
        4->"Wednesday"
        5->"Thursday"
        6->"Tuesday"
        7->"Tuesday"
        else->day="Invalid Option"
    }

    for(i in 0  until 5){
        println(i)
    }

    for(i in 0.. 5){
        println(i)
    }

    var data =listOf("sandis","ram")
    data.forEach{
        println(it)
    }


}