package com.example.summerpractic

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var clickMe: Button? = null
    private var name: EditText? = null
    private var age: EditText? = null
    private var height: EditText? = null
    private var weight: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickMe = findViewById<Button>(R.id.button)
        name = findViewById<EditText>(R.id.editName)
        age = findViewById<EditText>(R.id.editAge)
        weight = findViewById<EditText>(R.id.editWeight)
        height = findViewById<EditText>(R.id.editHeight)
        val resultClickMe = findViewById<TextView>(R.id.textViewResultClick)

        clickMe?.setOnClickListener {
            val name = name?.text.toString()
            val heightString = height?.text.toString()
            val weightString = weight?.text.toString()
            val ageString = age?.text.toString()
            val weight = weightString.toFloatOrNull()
            val height = heightString.toIntOrNull()
            val age = ageString.toIntOrNull()
            if (age != null && height != null && weight != null && name != null) {
                if(age>0 && age<150 && height>0 && height<250 && weight>0 && weight<250){
                    val pulse = calculatePulse(height,weight)
                    val number = calculateNumber(height,weight,age)
                    resultClickMe.text = "Ваш пульс: $pulse\nВаш номер: $number"
                }else {
                    Toast.makeText(this, "Некорректные данные!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }
        }
    }

    private fun calculateNumber(height: Int, weight: Float, age: Int): Any {
        return (height + age + weight + 100)
    }

    private fun calculatePulse(height: Int, weight: Float): Any {
        return height - weight
    }
}