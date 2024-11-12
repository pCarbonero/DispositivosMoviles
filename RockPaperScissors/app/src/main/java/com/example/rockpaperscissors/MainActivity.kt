package com.example.rockpaperscissors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.rockpaperscissors.dal.JugadoresDataBase
import com.example.rockpaperscissors.ui.views.Composables.GameScreen
import com.example.rockpaperscissors.ui.views.Composables.login
import com.example.rockpaperscissors.ui.views.Composables.winnerScreen

class MainActivity : ComponentActivity() {
    companion object{
        lateinit var database: JugadoresDataBase
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(
            applicationContext,
            JugadoresDataBase::class.java,
            name = "jugadores-db"
        ).fallbackToDestructiveMigration().build()
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "login"
            ) {
                composable("login") {login(navController)}
                composable("game/{idJugador}") { backStackEntry ->
                    GameScreen(navController, backStackEntry.arguments?.getString("idJugador").toString()) }
                composable("fin/{winner}") { backStackEntry ->
                winnerScreen(navController,
                backStackEntry.arguments?.getString("winner").toString())
                }
            }

        }
    }
}

