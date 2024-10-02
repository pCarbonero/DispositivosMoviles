package com.example.tarea1

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnSuma = findViewById<Button>(R.id.btnSuma)

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage("El campo debe ser un número")
            .setTitle("Error")

        val dialog: AlertDialog = builder.create()

        btnSuma.setOnClickListener {
            val num1 = findViewById<EditText>(R.id.num1)
            val num2 = findViewById<EditText>(R.id.num2)
            val textRes = findViewById<TextView>(R.id.textRes)
            val res: Double
            try{
                val a = num1.text.toString().toDouble()
                val b = num2.text.toString().toDouble()

                res = suma(a, b)

                textRes.text = res.toString()
            }
            catch (e: Exception){
                dialog.show()
             }
        }
    }


    fun suma(numA: Double, numB: Double): Double {
        return (numA + numB)
    }
}