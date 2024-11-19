package com.example.contactosdatabase.composables

import android.annotation.SuppressLint
import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.net.Uri
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.ContactosTarea2.R
import com.example.contactosdatabase.MainActivity.Companion.database
import com.example.contactosdatabase.dal.ContactoEntity

@Composable
fun ItemList(navController: NavController) {
    var itemContacto = remember { mutableStateListOf<ContactoEntity>() }

    LaunchedEffect(Unit) {
        itemContacto.addAll(database.contactoDao().getTodo())
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            items(itemContacto.size) { index ->
                ContactoView(contacto = itemContacto[index])
            }
        }

        // Botón flotante cuadrado
        androidx.compose.material3.FloatingActionButton(
            onClick = { navController.navigate("add") },
            modifier = Modifier
                .size(120.dp) // Tamaño cuadrado
                .align(Alignment.BottomEnd)
                .padding(bottom = 60.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
            ) {
                Text(
                    text = "+",
                    fontSize = 24.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}
@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
fun ContactoView(contacto: ContactoEntity) {
    val context = LocalContext.current
    var iniciales = contacto.nombre.first().toString() + contacto.apellido.first().toString()
    var nombreCompleto = contacto.nombre.toString() + " " + contacto.apellido.toString()
    var nombre by remember { mutableStateOf(iniciales) }
    var telefono = contacto.telefono
    var foto = contacto.imagen
    var isVisible by remember { mutableStateOf(false) }

    Card(Modifier.fillMaxWidth().padding(5.dp)) {
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
                        text = telefono.toString(),
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                val u = Uri.parse("tel:" + contacto.telefono)
                                val i = Intent(ACTION_DIAL, u)

                                try{
                                    context.startActivity(i)
                                }catch (e: Exception){
                                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                                }
                            }
                    )
                }
            }
        }
    }
}