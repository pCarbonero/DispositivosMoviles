package com.example.calculadorajpc.composables

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calculadorajpc.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun calculadora(navHostController: NavHostController) {
    var res by remember { mutableStateOf("0") }
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var context = LocalContext.current
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(218, 227, 255)),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = res,
            textAlign = TextAlign.Center,
            fontSize = 80.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier.padding(top = 100.dp)
        )

        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Valor 1") },
            modifier = Modifier.padding(top = 100.dp)
        )

        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Valor 2") },
            modifier = Modifier.padding(top = 10.dp)
        )

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 200.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            ////////////////////
            Button(
                onClick = {
                    if (comprobarDatos(num1,num2,context)) {
                        res = suma(num1,num2,context).toString()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(99, 111, 150),
                    contentColor = Color.White
                ),
                shape = CutCornerShape(10),
                modifier = Modifier.weight(1f)
            )
            {
                Text("+", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
            ///////////////////
            Button(
                onClick = {
                    if (comprobarDatos(num1,num2,context)) {
                        res = resta(num1,num2,context).toString()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(99, 111, 150),
                    contentColor = Color.White
                ),
                shape = CutCornerShape(10),
                modifier = Modifier.weight(1f)
            )
            {
                Text("-", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
            ///////////////////
            Button(
                onClick = {
                    if (comprobarDatos(num1,num2,context)) {
                        res = muliplicacion(num1,num2,context).toString()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(99, 111, 150),
                    contentColor = Color.White
                ),
                shape = CutCornerShape(10),
                modifier = Modifier.weight(1f)
            )
            {
                Text("*", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
            ///////////////////
            Button(
                onClick = {
                    if (comprobarDatos(num1,num2,context)) {
                        res = division(num1,num2,context).toString()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(99, 111, 150),
                    contentColor = Color.White
                ),
                shape = CutCornerShape(10),
                modifier = Modifier.weight(1f)
            )
            {
                Text("/", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }
    }
}

fun comprobarDatos(c1: String, c2: String, context: Context): Boolean {
    var esCorrecto = false
    if (!c1.isNullOrEmpty() && !c2.isNullOrEmpty()) {
        try {
            var a = c1.toFloat()
            var b = c2.toFloat()
            esCorrecto = true;
        } catch (e: NumberFormatException) {
            Toast.makeText(context, "Algún valor insertado no es numérico", Toast.LENGTH_SHORT)
                .show()
        }
    } else {
        Toast.makeText(context, "Hay almenos un campo vacio", Toast.LENGTH_SHORT).show()
    }

    return esCorrecto
}


fun suma(c1: String, c2: String, context: Context): Float {
    var res: Float = 0f
    var a: Float = 0f
    var b: Float = 0f

    a = c1.toFloat()
    b = c2.toFloat()
    res = a + b


    return res
}

fun resta(c1: String, c2: String, context: Context): Float {
    var res: Float = 0f
    var a: Float = 0f
    var b: Float = 0f

    a = c1.toFloat()
    b = c2.toFloat()
    res = a - b


    return res
}

fun muliplicacion(c1: String, c2: String, context: Context): Float {
    var res: Float = 0f
    var a: Float = 0f
    var b: Float = 0f

    a = c1.toFloat()
    b = c2.toFloat()
    res = a * b


    return res
}

fun division(c1: String, c2: String, context: Context): Float {
    var res: Float = 0f
    var a: Float = 0f
    var b: Float = 0f

    a = c1.toFloat()
    b = c2.toFloat()

    if(b == 0f){
        Toast.makeText(context, "No se puede dividir por 0", Toast.LENGTH_SHORT).show()
    }
    else{
        res = a / b
    }
    return res
}