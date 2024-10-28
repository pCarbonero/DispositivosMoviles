package com.example.elpesoideal_pablocarbonero.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun mostrarResultado(peso: String, altura: String, sexo: String, navController: NavHostController) {
    val pesoNum = peso.toFloat()
    val alturaNum = ((altura.toFloat())/100)
    var coeficiente: Float
    var tipoPeso: String = ""

    if (sexo == "Hombre"){
        coeficiente = 1f
    }
    else{
        coeficiente = 0.95f
    }

    val IMC = (pesoNum / (alturaNum*alturaNum))*coeficiente

    if (IMC < 18.5){
        tipoPeso = "Bajo peso"
    }
    else if(IMC >= 18.5 && IMC <= 24.9){
        tipoPeso = "Peso normal"
    }
    else if(IMC >= 25 && IMC <= 29.9){
        tipoPeso = "Sobrepeso"
    }
    else if(IMC >= 30f){
        tipoPeso = "Obesidad"
    }



    Column (Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = "IMC",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = IMC.toString(),
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 80.dp)
        )
        Text(
            text = tipoPeso,
            fontSize = 30.sp
        )
    }

}