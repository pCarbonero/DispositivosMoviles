package com.example.ejercicio04jpcomopse.composables

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ejercicio04jpcomopse.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun inicioSesion(vistaLoginNavController: NavHostController){
    var texto by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column (Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = "Iniciar sesion ",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 160.dp)
        )
        Box(Modifier.padding(bottom = 100.dp)){
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "foto inicio",
                Modifier.size(100.dp,100.dp)
            )
        }
        OutlinedTextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Usuario") }
        )
        OutlinedTextField(
            value = pw,
            onValueChange = { pw = it },
            label = { Text("Contraseña")},
            modifier = Modifier.padding(top = 30.dp)
        )

        Button(
            onClick = { cambiarPantalla(vistaLoginNavController, texto, context) }
        ) {
            Text("Entrar")
        }

    }
}

fun cambiarPantalla(vistaLoginNavController: NavHostController, campo:String, context: Context){
    if (campo.isNullOrEmpty()){
        vistaLoginNavController.navigate("main")
    }
    else{
        Toast.makeText(context, "Rellena el campo de usuario", Toast.LENGTH_SHORT).show()
    }
}