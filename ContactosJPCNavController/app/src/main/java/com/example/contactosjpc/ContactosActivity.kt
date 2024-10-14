package com.example.contactosjpc

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import com.example.contactosjpc.composables.ItemList
import com.example.contactosjpc.composables.SimpleTextField

class ContactosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                ItemList(
                    itemContacto = listOf(Contacto("Juan", "Sargento", "611123456", 0),
                        Contacto("María", "Velazquez","678456123", 1),
                        Contacto("Raúl", "Parra","644789456", 0),
                        Contacto("Pablo", "Carbonero", "123456789", 0),
                        Contacto("Sara", "Ruíz", "987654321", 1),
                        Contacto("Amador", "Rivas", "111111111", 0),
                        Contacto("Elena", "Lorenzo", "999777888", 1),
                        Contacto("Angy", "Díaz", "555444666", 1),
                        Contacto("Alicia", "Díaz", "222111333", 1),
                        Contacto("María", "Rivero", "678456123", 1),
                        Contacto("Alberto", "Barrera", "644789456", 0),
                        Contacto("Khaled", "García", "123456789", 0),
                        Contacto("Ted", "Kaczynski", "987654321", 1),
                        Contacto("Vera", "Almellones", "111111111", 1),
                        Contacto("Gon", "Freecs", "999777888", 0),
                        Contacto("Toji", "Fushiguro", "555444666", 0),
                        Contacto("Jolyne", "Kujo", "222111333", 1),
                        Contacto("Maki", "Zen'in", "693882147", 1)
                    )
                )
            }
        }
    }
}
