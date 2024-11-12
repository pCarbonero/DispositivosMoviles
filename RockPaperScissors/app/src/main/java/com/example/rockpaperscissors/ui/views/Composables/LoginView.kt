package com.example.rockpaperscissors.ui.views.Composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.rockpaperscissors.MainActivity.Companion.database
import com.example.rockpaperscissors.dal.JugadorEntity
import com.example.rockpaperscissors.dal.JugadoresDao
import com.example.rockpaperscissors.dal.JugadoresDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun login(navController: NavHostController) {
    var nombre by remember { mutableStateOf("") }
    var jugadores: List<JugadorEntity>
    var jugador: JugadorEntity
    var jugadorId:Long = 0
    //var jugadorId by remember { mutableStateOf(0) }
    // Mostrar la interfaz de usuario
    Column(
        Modifier.fillMaxSize().padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )

        Button(
            onClick = {
                if (nombre.isNotEmpty()) {
                    // Llamar a la función de inserción en un hilo de fondo
                    CoroutineScope(Dispatchers.IO).launch {
                        jugadores = database.jugadorDao().getTodo()
                        jugador = JugadorEntity(nombre = nombre)

                        val jugadorExistente = jugadores.find { it.nombre == nombre }

                        if (jugadorExistente == null){
                            jugadorId = database.jugadorDao().insertar(jugador)

                        }else{
                            jugador = jugadorExistente
                            database.jugadorDao().actualizar(jugador)
                            jugadorId=jugador.id
                        }

                        jugador.partidasJugadas+=1
                        database.jugadorDao().actualizar(jugador)

                        withContext(Dispatchers.Main){
                            navController.navigate("game/$jugadorId")
                        }
                    }
                    /////////////////
                }
            }
        ) {
            Text("Jugar")
        }
    }
}