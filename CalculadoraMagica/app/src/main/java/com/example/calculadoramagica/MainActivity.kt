package com.example.calculadoramagica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculadoramagica.composables.inicio
import com.example.calculadoramagica.composables.magia
import com.example.calculadoramagica.ui.theme.CalculadoraMagicaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "inicio"
            ){
                composable("inicio") { inicio(navController) }
                composable("magia/{num1}/{num2}"){ backStackEntry ->
                    magia(navController,
                        backStackEntry.arguments?.getString("num1").toString(),
                        backStackEntry.arguments?.getString("num2").toString())
                }
            }
        }
    }
}
