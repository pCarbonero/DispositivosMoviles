package com.example.tarea1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById < Button >(R.id.button4)
        val user = findViewById<EditText>(R.id.userTxt)
        val password = findViewById<EditText>(R.id.passwordTxt)

        boton.setOnClickListener {
            if (user.text.toString().equals("oliverSykes") && password.text.toString().equals("Sempiternal") ){
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            }
            else{
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

    }
}