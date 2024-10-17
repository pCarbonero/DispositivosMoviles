package com.example.ejercicio04jpcomopse.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun mainPantalla(vistaMainNavController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize().padding(30.dp,50.dp)
            .border(10.dp, Color.Black, RoundedCornerShape(16.dp)) // Borde negro de 4 dp alrededor
            .background(Color.LightGray)
    )
}