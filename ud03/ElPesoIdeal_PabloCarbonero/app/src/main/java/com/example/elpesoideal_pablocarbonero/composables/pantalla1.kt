package com.example.elpesoideal_pablocarbonero.composables

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun seleccionarSexo(navController: NavController){
    var nombre by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("") }
    var context = LocalContext.current
    Column (Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = "CALCULADORA IMC",
            fontSize = 40.sp,
            modifier = Modifier.padding(bottom = 100.dp)
        )
        OutlinedTextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = { Text("Nombre")}
        )

        Row (Modifier.padding(top = 100.dp)) {
            Button(onClick = {
                sexo = "Hombre"
                irAltura(nombre, sexo, context, navController)}) {
                Text("Hombre")
            }
            Button(onClick = {
                sexo = "Mujer"
                irAltura(nombre, sexo, context, navController)}) {
                Text("Mujer")
            }
        }
    }
}

fun irAltura(nombre: String, sexo: String, context: Context, navController: NavController){
    if (nombre.isNullOrEmpty() || sexo.isNullOrEmpty()){
        Toast.makeText(context, "Inserta correctamente los campos", Toast.LENGTH_SHORT).show()
    }
    else{
        try {
            navController.navigate("altura/$nombre/$sexo")
        }
        catch (e:Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }

    }
}

