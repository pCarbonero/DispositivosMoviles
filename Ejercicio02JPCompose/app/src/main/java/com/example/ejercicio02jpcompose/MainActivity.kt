package com.example.ejercicio02jpcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicio02jpcompose.ui.theme.Ejercicio02JPComposeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio02JPComposeTheme {
                var lista = listOf(
                    Articulo("Ps5", 499.99f),
                    Articulo("Xbox One", 499.99f),
                    Articulo("Nintendo Switch", 299.99f),
                    Articulo("Steam Deck", 599.99f),
                    Articulo("Aorus PC Gaming", 899.99f),
                    Articulo("Nintendo Switch 2", 499.99f),
                    Articulo("Nintendo Switch", 299.99f),
                    Articulo("Steam Deck", 599.99f),
                    Articulo("Aorus PC Gaming", 899.99f),
                    Articulo("Nintendo Switch 2", 499.99f),
                    Articulo("Nintendo Switch", 299.99f),
                    Articulo("Steam Deck", 599.99f),
                    Articulo("Aorus PC Gaming", 899.99f),
                    Articulo("Aorus PC Gaming", 899.99f)

                )
                MaterialTheme {
                    productosColumn(lista)
                }
            }
        }
    }
}

@Composable
fun productosColumn(lista: List<Articulo>) {
    var total by remember { mutableStateOf(0f) }

    Box(Modifier.fillMaxSize()) {
        LazyColumn {
            items(lista.size) { index ->
                productosView(lista[index]) { precioCambio ->
                    total += precioCambio // Actualiza el total sumando o restando el valor
                }
            }
        }
        barraBaja(total)
    }
}

@Composable
fun productosView(articulo: Articulo, onPrecioCambio: (Float) -> Unit) {
    var isChecked by remember { mutableStateOf(false) }

    Card(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = articulo.nombre
            )
            Text(
                text = ": " + articulo.precio.toString() + "€"
            )

            Checkbox(
                checked = isChecked,
                onCheckedChange = { checked ->
                    val precioCambio = if (checked) articulo.precio else -articulo.precio
                    isChecked = checked
                    onPrecioCambio(precioCambio) // Actualiza el total
                },
                modifier = Modifier
                    .weight(1f)
                    .clickable { }
            )
        }
    }
}

@Composable
fun barraBaja(total: Float) {
    Box(Modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(color = Color.Gray)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Precio total: $total",
                textAlign = TextAlign.Center
            )
        }
    }
}

