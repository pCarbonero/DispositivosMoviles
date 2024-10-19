package com.example.calculadorajpc.composables

import android.content.Context
import android.provider.CalendarContract.Colors
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.ViewRootForTest
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.calculadorajpc.R

@Composable
fun login(navHostController: NavHostController){
    var nombreUsuario by rememberSaveable { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }
    var context = LocalContext.current
    Column (
        Modifier
            .fillMaxSize()
            .background(color = Color(153, 178, 255)),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(Modifier.padding(top = 80.dp)){
            Image(
                painter = painterResource(id = R.drawable.calcualtor),
                contentDescription = "AA",
                modifier = Modifier.size(150.dp,150.dp)
            )
        }

        Text(
            text = "CALCULADORA\nJET PACK COMPOSE",
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 50.dp)
        )

        TextField(
            value = nombreUsuario,
            onValueChange = {nombreUsuario = it},
            label = { Text("Usuario") },
            modifier = Modifier
                .padding(top = 100.dp)
                .background(color = Color(218, 227, 255))
        )

        TextField(
            value = contraseña,
            onValueChange = {contraseña = it},
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .padding(top = 10.dp)
                .background(color = Color(218, 227, 255))
        )

        Button(
            onClick = { entrarCalcualdora(navHostController, nombreUsuario, context)},
            modifier = Modifier.padding(top=100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Text(
                "Acceder",
                fontWeight = FontWeight.Bold
            )
        }

    }
}

fun entrarCalcualdora(navHostController: NavHostController, campoUsuario: String, context: Context){
    if (!campoUsuario.isNullOrEmpty()){
        Toast.makeText(context, "El campo usuario está vacío", Toast.LENGTH_SHORT).show()
    }
    else{
        navHostController.navigate("calculadora")
    }
}

