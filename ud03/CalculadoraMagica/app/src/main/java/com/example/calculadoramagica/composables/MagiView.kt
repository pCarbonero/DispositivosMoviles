package com.example.calculadoramagica.composables

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun magia(navHostController: NavHostController, num1: String, num2: String) {
    val a = num1.toFloat()
    val b = num2.toFloat()
    var res by remember { mutableStateOf(0f) }
    var isVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(218, 227, 255)),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Card (shape = RoundedCornerShape(20.dp), elevation = CardDefaults.cardElevation(10.dp), modifier = Modifier.padding(top = 20.dp).size(100.dp,100.dp)) {
            AnimatedVisibility(visible = isVisible) {
                Text(
                    text = res.toString(),
                    textAlign = TextAlign.Center,
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
            }
        }
        Text(
            text = "MAGIA",
            textAlign = TextAlign.Center,
            fontSize = 80.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier.padding(top = 100.dp)
                .clickable {
                    navHostController.popBackStack()
                }
        )

        Column (Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row() {
                Button(onClick = {
                    res=a+b
                    isVisible = true }) { }
                Button(onClick = {
                    res = a-b
                    isVisible = true
                }) { }
            }
            Row(Modifier.padding(bottom = 50.dp)) {
                Button(onClick = {
                    res=a*b
                    isVisible = true }) { }
                Button(onClick = {
                    if (b!=0f){
                        res = a/b
                        isVisible = true
                    }
                    else{
                        Toast.makeText(context, "No se puede dividir por 0", Toast.LENGTH_SHORT).show()
                }
                }) { }
            }
        }
    }
}