package com.example.contactosjpc.composables

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactosjpc.Contacto
import com.example.contactosjpc.ContactosActivity
import com.example.contactosjpc.R

// recive por parametros la informacion enviadada desde el putExtra
@Composable
fun LlamadaContacto(nombre: String, numero: String, imagen: Int){
    val context = LocalContext.current
    var foto = R.drawable._29466_man_512x512
    if (imagen == 1) {
        foto = R.drawable.fmale
    }
    else{
        foto = R.drawable._29466_man_512x512
    }
    Column(Modifier.padding(top = 90.dp).fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = foto),
            contentDescription = "Foto contacto",
            Modifier.height(150.dp)
        )
        Text(text = nombre,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold)
        Text(text = numero,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 25.dp))
        Text(text = "Llamando...",
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 45.dp))
        Image(
            painter = painterResource(R.drawable.endcall),
            contentDescription = "Colgar",
            Modifier.height(300.dp).padding(top = 200.dp).clickable {
                val intent = Intent(context, ContactosActivity::class.java).apply {
                    // limpiamos para el correcto funcionamiento al pulsar el boton de volver
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                }
                context.startActivity(intent)
            }
        )
    }
}