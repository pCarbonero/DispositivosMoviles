package com.example.calculadoramagica.composables

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calculadoramagica.R

@Composable
fun inicio(navHostController: NavHostController){
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column (
        Modifier
            .fillMaxSize()
            .background(color = Color(153, 178, 255)),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(Modifier.padding(top = 80.dp)){
            Image(
                painter = painterResource(id = R.drawable.asteti),
                contentDescription = "AA",
                colorFilter = ColorFilter.tint(Color.Green),
                modifier = Modifier.size(150.dp,150.dp)
            )
        }

        Text(
            text = "CALCULADORA\nMÁGICA",
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 50.dp)
        )

        TextField(
            value = num1,
            onValueChange = {num1 = it},
            label = { Text("VALOR 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(top = 100.dp)
                .background(color = Color(218, 227, 255))
        )

        TextField(
            value = num2,
            onValueChange = {num2 = it},
            label = { Text("VALOR 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(top = 10.dp)
                .background(color = Color(218, 227, 255))
        )

        Button(
            onClick = { hacerMagia(navHostController, num1, num2, context) },
            shape = CutCornerShape(10),
            modifier = Modifier
                .padding(top = 100.dp)
                .size(150.dp, 100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Text(
                "Haz magia",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
        }

    }
}

fun hacerMagia(navHostController: NavHostController, num1: String, num2: String, context: Context){
    if (comprobarValoresInsertados(num1,num2)){
        navHostController.navigate("magia/$num1/$num2")
    }
    else{
        Toast.makeText(context, "Los valores insertados no son correctos o están vacíos", Toast.LENGTH_SHORT).show()
    }
}

fun comprobarValoresInsertados (num1: String, num2: String): Boolean{
    var esCorrecto: Boolean

    // con el try catch comprobamos que los valores insertados son numeros
    try {
        var a = num1.toFloat()
        var b = num2.toFloat()
        esCorrecto = true
    }catch (e:Exception){
        esCorrecto = false
    }

    return esCorrecto
}
