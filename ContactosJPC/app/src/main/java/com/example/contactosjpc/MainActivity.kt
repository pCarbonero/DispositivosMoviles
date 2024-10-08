package com.example.contactosjpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactosjpc.composables.ItemList
import com.example.contactosjpc.composables.SimpleTextField
import com.example.contactosjpc.ui.theme.ContactosJPCTheme

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