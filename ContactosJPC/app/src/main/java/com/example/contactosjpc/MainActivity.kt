package com.example.contactosjpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import com.example.contactosjpc.composables.SimpleTextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                SimpleTextField()
            }
        }
    }
}

/*
*                 ItemList(
                    itemContacto = listOf(Contacto("Juan","611123456", 0),
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
                )
* */