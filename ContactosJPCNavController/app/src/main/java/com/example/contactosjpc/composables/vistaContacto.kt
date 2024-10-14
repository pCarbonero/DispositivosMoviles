package com.example.contactosjpc.composables

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactosjpc.Contacto
import com.example.contactosjpc.R
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.contactosjpc.ContactosActivity
import com.example.contactosjpc.ui.theme.LlamadaActivity

@Composable
fun ItemList(itemContacto: List<Contacto>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        // Iteramos sobre la lista de contactos
        items(itemContacto.size) { index ->
            ContactoView(contacto = itemContacto[index])
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
fun ContactoView(contacto: Contacto) {
    val context = LocalContext.current
    var iniciales = contacto.nombre.first().toString() + contacto.apellido.first().toString()
    var nombreCompleto = contacto.nombre.toString() + " " + contacto.apellido.toString()
    var nombre by remember { mutableStateOf(iniciales) }
    var telefono = contacto.telefono
    var foto = R.drawable._29466_man_512x512
    var isVisible by remember { mutableStateOf(false) }

    if (contacto.imagen == 1) {
        foto = R.drawable.fmale
    }
    Card(Modifier.fillMaxWidth()) {
        Row(Modifier.padding(top = 20.dp, bottom = 40.dp)) {
            Column() {
                Image(
                    painter = painterResource(id = foto),
                    contentDescription = "Foto contacto",
                    Modifier
                        .height(70.dp)
                        .clickable {
                            if (nombre == nombreCompleto) {
                                nombre = iniciales
                                isVisible = false
                            } else {
                                nombre = nombreCompleto
                                isVisible = true
                            }
                        }
                )
            }
            Column() {
                Text(
                    text = nombre,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp)
                )
                AnimatedVisibility(
                    visible = isVisible,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Text(
                        text = telefono,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                val intent =
                                    Intent(context, LlamadaActivity::class.java).apply {
                                        // con put extra podemos enviar los datos deseados a la activity que se va a iniciar
                                        putExtra("nombre", nombre)
                                        putExtra("numero", telefono)
                                        putExtra("imagen", contacto.imagen)
                                    }
                                context.startActivity(intent)

                            }
                    )
                }
            }
        }
    }
}