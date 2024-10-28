package com.example.tarea1

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.shape.ShapeAppearanceModel.builder

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

        // VARIABLES PARA ALMACENAR LOS BOTONES
        val btnSuma = findViewById<Button>(R.id.btnSuma)
        val btnResta = findViewById<Button>(R.id.btnResta)
        val btnMulti = findViewById<Button>(R.id.btnMulti)
        val btnDiv = findViewById<Button>(R.id.btnDiv)


        // VARIABLES PARA LOS NUMEROS Y REALIZAR LAS OPERACIONES
        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        val textRes = findViewById<TextView>(R.id.textRes)
        var res: Double
        var a: Double
        var b: Double

        btnSuma.setOnClickListener {
            if (!camposVacios(num1, num2)){
                a = num1.text.toString().toDouble()
                b = num2.text.toString().toDouble()
                res = a + b
                textRes.text = res.toString()
            }
        }// btnSuma

        btnResta.setOnClickListener {
            if (!camposVacios(num1, num2)){
                a = num1.text.toString().toDouble()
                b = num2.text.toString().toDouble()
                res = a - b
                textRes.text = res.toString()
            }
        }// btnResta

        btnMulti.setOnClickListener {
            if (!camposVacios(num1, num2)){
                a = num1.text.toString().toDouble()
                b = num2.text.toString().toDouble()
                res = a * b
                textRes.text = res.toString()
            }
        }// btnMulti

        btnDiv.setOnClickListener {
            if (!camposVacios(num1, num2)){
                a = num1.text.toString().toDouble()
                b = num2.text.toString().toDouble()

                if (b == 0.0){
                    Toast.makeText(this, "No se puede dividir por 0", Toast.LENGTH_SHORT).show()
                }
                else{
                    res = a / b
                    textRes.text = res.toString()
                }
            }
        }// btnDiv
    }

    fun camposVacios(num1: EditText, num2:EditText): Boolean{
        if (num1.text.isEmpty() || num2.text.isEmpty()){
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            return true
        }
        else return false
    }

}