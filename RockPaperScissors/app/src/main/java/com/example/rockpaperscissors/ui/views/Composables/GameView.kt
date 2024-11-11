package com.example.rockpaperscissors.ui.views.Composables

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.listatareabd.R
import kotlin.random.Random

@Composable
fun GameScreen(navController: NavHostController) {
    Box(Modifier.fillMaxSize()){
        val context = LocalContext.current

        var isVisible by remember { mutableStateOf(false) }

        var res by remember{ mutableStateOf(0)}

        var blueScore by remember{ mutableStateOf(0)}
        var redScore by remember{ mutableStateOf(0)}

        var enemyMove by remember { mutableStateOf(0) }
        var playerMove by remember { mutableStateOf(0) }

        var enemy by remember{ mutableStateOf(R.drawable.ic_launcher_background)}
        var player by remember{ mutableStateOf(R.drawable.ic_launcher_background)}

        if (enemyMove == 1){
            enemy = R.drawable.rock
        }
        else if(enemyMove == 2){
            enemy = R.drawable.paper
        }else if(enemyMove == 3){
            enemy = R.drawable.scissors
        }

        if (playerMove == 1){
            player = R.drawable.rock
        }
        else if(playerMove == 2){
            player = R.drawable.paper
        }else if(playerMove == 3){
            player = R.drawable.scissors
        }

        if (redScore == 3){
            navController.navigate("fin/2")
            redScore = 0
        }
        if (blueScore == 3){
            navController.navigate("fin/1")
            blueScore = 0
        }



        Column (Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Ocupa la mitad superior
                    .background(color = Color(243, 139, 139))
            ) {
                Box(
                    Modifier
                        .border(2.dp, Color.Black)
                        .size(70.dp)
                        .align(Alignment.BottomStart),
                    contentAlignment = Alignment.Center)
                {
                    Text(redScore.toString(), fontWeight = FontWeight.Bold, fontSize = 35.sp)
                }// redScore
                Box(
                    Modifier
                        .size(180.dp)
                        .align(Alignment.BottomCenter)
                        .padding(30.dp),
                    contentAlignment = Alignment.Center){
                    Column (Modifier.fillMaxSize()){
                        AnimatedVisibility(visible = isVisible, enter = fadeIn())
                        {
                            Image(painter = painterResource(id = enemy),
                                contentDescription = "tijera",
                                Modifier.fillMaxSize())
                        }
                    }
                }// enemyMove
                   /* Box(
                        Modifier
                            .size(160.dp)
                            .align(Alignment.BottomEnd),
                        contentAlignment = Alignment.Center){
                        Column (Modifier.fillMaxSize()){
                            Image(painter = painterResource(id = R.drawable.sukuna1),
                                contentDescription = "tijera",
                                Modifier.fillMaxSize())
                        }
                    }// enemyImage*/
            }// redBox
            Divider(
                color = Color.Black,
                thickness = 2.dp, // Ajusta el grosor a tu preferencia
                modifier = Modifier.fillMaxWidth()
            )
            // lado del jugador
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.5f)
                    .background(color = Color(156, 172, 222))
            ) {
                Box(
                    Modifier
                        .border(2.dp, Color.Black)
                        .size(70.dp)
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center)
                {
                    Text(blueScore.toString(), fontWeight = FontWeight.Bold, fontSize = 35.sp)
                }// blueScore

                Box(
                    Modifier
                        .size(180.dp)
                        .align(Alignment.TopCenter)
                        .padding(30.dp),
                    contentAlignment = Alignment.Center){
                    Column (Modifier.fillMaxSize()){
                        AnimatedVisibility(visible = isVisible, enter = fadeIn())
                        {
                            Image(painter = painterResource(id = player),
                                contentDescription = "tijera",
                                Modifier.fillMaxSize())
                        }
                    }
                }// playerMove
                /*Box(
                    Modifier
                        .size(180.dp)
                        .align(Alignment.BottomStart).padding(bottom = 30.dp),
                    contentAlignment = Alignment.Center){
                    Column (Modifier.fillMaxSize()){
                        Image(painter = painterResource(id = R.drawable.gojo1),
                            contentDescription = "tijera",
                            Modifier.fillMaxSize())
                    }
                }// playerImage*/

                Row (
                    Modifier
                        .fillMaxSize()
                        .padding(bottom = 200.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.Bottom) {

                    // botones
                    Image(painter = painterResource(id = R.drawable.rock),
                        contentDescription = "piedra",
                        Modifier
                            .size(80.dp)
                            .weight(1f)
                            .clickable {
                                enemyMove = enemyMove()
                                playerMove = 1
                                res = duelo(enemyMove, playerMove, context)
                                if (res == 1) {
                                    blueScore++
                                } else if (res == 2) {
                                    redScore++
                                }
                                isVisible = true
                            })

                    Image(painter = painterResource(id = R.drawable.paper),
                        contentDescription = "papel",
                        Modifier
                            .size(80.dp)
                            .weight(1f)
                            .clickable {
                                enemyMove = enemyMove()
                                playerMove = 2
                                res = duelo(enemyMove, playerMove, context)
                                if (res == 1) {
                                    blueScore++
                                } else if (res == 2) {
                                    redScore++
                                }
                                isVisible = true
                            })

                    Image(painter = painterResource(id = R.drawable.scissors),
                        contentDescription = "tijera",
                        Modifier
                            .size(80.dp)
                            .weight(1f)
                            .clickable {
                                enemyMove = enemyMove()
                                playerMove = 3
                                res = duelo(enemyMove, playerMove, context)
                                if (res == 1) {
                                    blueScore++
                                } else if (res == 2) {
                                    redScore++
                                }
                                isVisible = true
                            })
                }
            }// blueBox
        }// Column
    }
}

fun enemyMove(): Int {
    val move = Random.nextInt(1, 4)
    return move
}

fun duelo(enMove: Int, plMove: Int, context: Context): Int {
    var winner = 0
    var message = "Empate"
    // piedra: 1, papel: 2, tijeras: 3
    // si devuelve 0 empate
    // si devuelve 1 gana player
    // si devuelve 2 gana enemy
    if (enMove != plMove) {
        if (plMove == 1 && enMove == 2) {
            winner = 2
        } else if (plMove == 1 && enMove == 3) {
            winner = 1
        } else if (plMove == 2 && enMove == 1) {
            winner = 1
        } else if (plMove == 2 && enMove == 3) {
            winner = 2
        } else if (plMove == 3 && enMove == 1) {
            winner = 2
        } else if (plMove == 3 && enMove == 2) {
            winner = 1
        }
    }

    if (winner == 1){
        message = "Has ganado"
    }
    else if (winner == 2){
        message = "Has perdido"
    }
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    return winner
}