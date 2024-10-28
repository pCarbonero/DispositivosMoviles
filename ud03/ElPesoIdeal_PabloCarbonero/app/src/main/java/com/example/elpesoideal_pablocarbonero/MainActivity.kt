package com.example.elpesoideal_pablocarbonero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elpesoideal_pablocarbonero.composables.mostrarResultado
import com.example.elpesoideal_pablocarbonero.composables.seleccionarAltura
import com.example.elpesoideal_pablocarbonero.composables.seleccionarSexo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var itemAltura = listOf(
                "145", "150", "155", "160", "165", "170",
                "175", "180", "185", "190", "195",
                "200", "205", "210", "215", "220"
            )


            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "sexo"
            ) {
                composable("sexo") { seleccionarSexo(navController) }
                composable("altura/{nombre}/{sexo}") { backStackEntry ->
                    seleccionarAltura(
                        backStackEntry.arguments?.getString("nombre").toString(),
                        backStackEntry.arguments?.getString("sexo").toString(),
                        navController, itemAltura
                    )
                }
                composable("resultado/{peso}/{altura}/{sexo}") { backStackEntry ->
                    mostrarResultado(
                        backStackEntry.arguments?.getString("peso").toString(),
                        backStackEntry.arguments?.getString("altura").toString(),
                        backStackEntry.arguments?.getString("sexo").toString(),
                        navController
                    )
                }
            }
        }
    }
}
