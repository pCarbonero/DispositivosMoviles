package com.example.ejercicio03jpcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicio03jpcompose.ui.theme.Ejercicio03JPComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio03JPComposeTheme {
                MaterialTheme { Profile() }
            }
        }
    }
}

@Composable
fun Profile() {
    Box(Modifier.fillMaxSize()){
        Column (Modifier.padding(top = 90.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "PROFILE",
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.que),
                contentDescription = "aaa",
                Modifier.size(200.dp,200.dp).padding(top = 20.dp)
            )
            Text(
                text = "Rigby"
            )
            Text(
                text = "123456789",
                color = Color.Gray
            )
            Text(
                text = "robipqlodiseasielinternete@gmail.rs",
                color = Color.Gray
            )

            Row (Modifier.padding(top = 120.dp).fillMaxWidth().background(Color.LightGray),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.que),
                    contentDescription = "aaa",
                    Modifier.size(40.dp,40.dp).weight(1f)
                )
                Text(
                    text = "Order History",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(3f))
            }
        }
        Row(Modifier.align(Alignment.BottomCenter)
            .fillMaxWidth()
            .background(Color.Gray)
            .height(100.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "aaa",
                Modifier.size(50.dp,50.dp).weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "aaa",
                Modifier.size(50.dp,50.dp).weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "aaa",
                Modifier.size(50.dp,50.dp).weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "aaa",
                Modifier.size(50.dp,50.dp).weight(1f)
            )
        }
    }
}
