package com.example.rockpaperscissors.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.rockpaperscissors.R

@Composable
fun winnerScreen(navController: NavHostController, winner: String) {
    var winImage by remember { mutableStateOf(R.drawable.gojowin) }
    var colorWin = Color(156, 172, 222)
    var text = "Has ganado"

    if (winner.toInt() == 2) {
        colorWin = Color(243, 139, 139)
        winImage = R.drawable.sukuna2
        text = "Has perdido"
    }


    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorWin),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text, fontSize = 60.sp,
            modifier = Modifier.padding(top = 100.dp))
        Button(onClick = {navController.navigate("game")}) { Text("Volver")}
    }
    Image(
        painter = painterResource(id = winImage),
        contentDescription = "win",
        Modifier.size(1100.dp).padding(top = 410.dp)
    )
}