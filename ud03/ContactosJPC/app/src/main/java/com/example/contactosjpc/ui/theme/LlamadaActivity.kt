package com.example.contactosjpc.ui.theme

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.contactosjpc.composables.ContactoView
import com.example.contactosjpc.composables.SimpleTextField
import com.example.contactosjpc.composables.LlamadaContacto

class LlamadaActivity  : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                val nombre = intent.getStringExtra("nombre").toString()
                val numero = intent.getStringExtra("numero").toString()
                val imagen: Int = intent.getIntExtra("imagen", 0)
                LlamadaContacto(nombre, numero, imagen)
            }
        }
    }
}