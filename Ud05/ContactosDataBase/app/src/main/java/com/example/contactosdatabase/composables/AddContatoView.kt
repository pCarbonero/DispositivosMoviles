package com.example.contactosdatabase.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ContactosTarea2.R
import com.example.contactosdatabase.MainActivity.Companion.database
import com.example.contactosdatabase.dal.ContactoEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun addContacto(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var imagen by remember { mutableStateOf(0) }
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )
        TextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text("Apellido") }
        )
        TextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") }
        )
        Box(){
            Button(onClick = {expanded = !expanded}) { Text("Icono") }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },

                ){
                val imageList = listOf(
                    R.drawable.fmale,
                    R.drawable._29466_man_512x512,
                    R.drawable.ic_launcher_foreground,
                    R.drawable.endcall
                )

                imageList.forEach { foto ->
                    DropdownMenuItem(
                        text = {
                            Image(
                                painter = painterResource(id = foto),
                                contentDescription = "A",
                                modifier = Modifier.size(30.dp)
                            )
                        },
                        onClick = {
                            imagen = foto
                            expanded = false
                        }
                    )

                }
        }

        }
        Button(
            onClick = {
                if (nombre.isNotEmpty() && apellido.isNotEmpty() && telefono.isNotEmpty()) {
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            val nuevoContacto = ContactoEntity(
                                nombre = nombre,
                                apellido = apellido,
                                telefono = telefono.toInt(),
                                imagen = imagen
                            )
                            database.contactoDao().insertar(nuevoContacto)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    navController.navigate("contactos")
                }
            }
        ) {
            Text("Añadir contacto")
        }
    }
}
