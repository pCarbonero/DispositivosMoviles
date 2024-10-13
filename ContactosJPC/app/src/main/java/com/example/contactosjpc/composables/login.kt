package com.example.contactosjpc.composables

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactosjpc.ContactosActivity
import com.example.contactosjpc.R



@Composable
fun SimpleTextField() {
    val context = LocalContext.current
    var text by rememberSaveable { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.cont),
            contentDescription = "Foto inicio",
            modifier = Modifier.height(300.dp).padding(top = 100.dp, end = 20.dp)
        )

        Text(
            modifier = Modifier.padding(top = 60.dp),
            text = "CONTACTOS",
            color = Color(2,0, 30),
            fontSize = 40.sp,
            fontWeight = Bold
        )

        TextField(
            modifier = Modifier.padding(top = 140.dp),
            value = text,
            onValueChange = { text = it },
            label = { Text("Usuario") }

        )
        TextField(
            modifier = Modifier.padding(top = 40.dp),
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            onClick = {
            if (text.isEmpty())
            {
                Toast.makeText(context, "Inserta un nombre de usuario", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(context, ContactosActivity::class.java)
                context.startActivity(intent)
            }
        },
            colors = ButtonDefaults.buttonColors(Color(67,168, 255)),
            modifier = Modifier.padding(top = 40.dp)
            ) {
            Text("Acceder");
        }

    }
}



