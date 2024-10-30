package com.example.rockpaperscissors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rockpaperscissors.Composables.GameScreen
import com.example.rockpaperscissors.Composables.winnerScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "game"
            ) {
                composable("game") { GameScreen(navController) }
                composable("fin/{winner}") { backStackEntry ->
                winnerScreen(navController,
                backStackEntry.arguments?.getString("winner").toString())}
            }

        }
    }
}

