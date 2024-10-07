package com.example.listacontactos

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val contactos = listOf(
            Contacto("Juan","611123456", 0),
            Contacto("María","678456123", 1),
            Contacto("Raúl","644789456", 0),
            Contacto("Pablo","123456789", 0),
            Contacto("Sara","987654321", 1),
            Contacto("Amador","111111111", 0),
            Contacto("Elena","999777888", 1),
            Contacto("Angy","555444666", 1),
            Contacto("Alicia","222111333", 1),
            Contacto("Ana","693882147", 1)
        )
        val adapter = ContactosAdapter(contactos)
        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.vistaContactos)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)

    }
}

