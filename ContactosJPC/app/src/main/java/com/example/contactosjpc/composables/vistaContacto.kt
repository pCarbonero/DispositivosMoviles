package com.example.contactosjpc.composables

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactosjpc.Contacto
import com.example.contactosjpc.R

@Composable
fun ItemList(itemContacto: List<Contacto>  ) {
    LazyColumn {	// produce una lista de desplazamiento vertical,
        items(itemContacto) { itemContacto ->
            ContactoView(contacto = itemContacto)

        }}
}

@Composable
fun ContactoView(contacto: Contacto) {
    var foto = R.drawable._29466_man_512x512
    if (contacto.imagen == 1){
        foto = R.drawable.fmale
    }
    Card(Modifier.fillMaxWidth()) {
        Row {
            Column {
                Image(
                    painter = painterResource(id = foto),
                    contentDescription = "Foto contacto",
                    Modifier.height(100.dp)
                )
            }
            Column {
                Text(
                    text = contacto.nombre,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = contacto.telefono,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}