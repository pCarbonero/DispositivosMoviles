package com.example.ejercicio01jpcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicio01jpcompose.ui.theme.Ejercicio01JPComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var listaAnimales = listOf(
                Animal("Gato", "ES UN GATO"),
                Animal("Perro", "ES UN Perro"),
                Animal("Trigre", "ES UN TRIGRE"),
                Animal("Rinoceronte", "ES UN RINOCERONTE"),
                Animal("Cerdo", "ES UN CERDITO"),
                Animal("Cabra", "ES UNA CABRA"),
                Animal("Vaca", "ES UNA VACA"),
                Animal("Toro", "ES UN Toro"),
                Animal("Canguro", "ES UN CANGURO"),
                Animal("Triceratops", "ES UN TRICERATOPS"),
                Animal("Cristiano Ronaldo", "ES EL BICHOO SUUU"),
                Animal("Messi", "ES LA PULGA"),
                Animal("Cangrejo", "ES UN CANGREJO"),
                Animal("GOKU", "ES GOKU"),
                Animal("Chileno", "ES ARTURO VIDAL")

            )
            Ejercicio01JPComposeTheme {
                Columna(listaAnimales)
            }
        }
    }
}

@Composable
fun Columna(lista: List<Animal>) {
    LazyColumn {
        items(lista.size) { index ->
            AnimalesView(animal = lista[index])
        }
    }
}

@Composable
fun AnimalesView(animal: Animal) {
    var isVisible by remember { mutableStateOf(false) }
    Card(Modifier.fillMaxWidth().clickable {
        if (isVisible){
            isVisible = false
        }
        else{
            isVisible = true
        }
    }) {
        Row(Modifier.padding(top = 50.dp)) {
            Column {
                Text(
                    text = animal.nombre
                )
                AnimatedVisibility(
                    visible = isVisible,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Text(
                        text = animal.descripcion
                    )
                }
            }
        }
    }
}