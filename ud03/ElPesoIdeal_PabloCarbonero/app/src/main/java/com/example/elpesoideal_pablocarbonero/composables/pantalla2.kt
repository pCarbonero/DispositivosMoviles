package com.example.elpesoideal_pablocarbonero.composables

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
@Composable
fun seleccionarAltura(nombre: String, sexo: String, navController: NavController, itemAltura: List<String>){
    var peso by remember { mutableStateOf("") }
    Column (
        Modifier
            .fillMaxSize()
            .padding(top = 80.dp)
        , horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = nombre,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = sexo,
            fontSize = 30.sp
        )
        OutlinedTextField(
            value = peso,
            onValueChange = {peso = it},
            label = { Text("Peso (Kg)")},
            modifier = Modifier.padding(top = 30.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
    Column (
        Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp), verticalArrangement = Arrangement.Bottom) {
        Row(
            Modifier.fillMaxWidth().height(200.dp)
        ){
            LazyColumn(Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom) {
                // Iteramos sobre la lista de contactos
                items(itemAltura.size) { index ->
                    listaAlturas(altura = itemAltura[index], peso, navController, sexo)
                }
            }
        }
    }
}


@Composable
fun listaAlturas(altura: String, peso:String, navController: NavController, sexo: String){
    val context = LocalContext.current
    Card (
        Modifier
            .fillMaxSize()
            .clickable { irResultado(altura, peso, sexo, navController, context) }) {
        Text(
            text = altura + "cm",
            fontSize = 25.sp
        )
    }
}

fun irResultado(altura: String, peso: String, sexo: String, navController: NavController, context: Context){

    if (comprobarPeso((peso))){
        navController.navigate("resultado/$peso/$altura/$sexo")
    }
    else{
        Toast.makeText(context, "El peso introducido no es correcto", Toast.LENGTH_SHORT).show()
    }

}

fun comprobarPeso(peso: String): Boolean{
    var esCorrecto: Boolean
    try{
        peso.toFloat()
        esCorrecto = true
    }
    catch(e:Exception){
        esCorrecto = false
    }
    return esCorrecto
}