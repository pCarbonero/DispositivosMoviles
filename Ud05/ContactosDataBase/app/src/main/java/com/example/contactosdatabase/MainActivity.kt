package com.example.contactosdatabase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.contactosdatabase.composables.Contacto
import com.example.contactosdatabase.composables.ItemList
import com.example.contactosdatabase.composables.addContacto
import com.example.contactosdatabase.composables.login
import com.example.contactosdatabase.dal.ContactosDatabase
import com.example.contactosdatabase.ui.theme.ContactosDataBaseTheme

class MainActivity : ComponentActivity() {
    companion object{
        lateinit var database: ContactosDatabase
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(
            applicationContext,
            ContactosDatabase::class.java,
            "contactos-db"
        ).build()

        enableEdgeToEdge()
        setContent {
            var itemContacto = listOf(
                Contacto("Juan", "Sargento", "611123456", 0),
                Contacto("María", "Velazquez", "678456123", 1),
                Contacto("Raúl", "Parra", "644789456", 0),
                Contacto("Pablo", "Carbonero", "123456789", 0),
                Contacto("Sara", "Ruíz", "987654321", 1),
                Contacto("Amador", "Rivas", "111111111", 0),
                Contacto("Elena", "Lorenzo", "999777888", 1),
                Contacto("Angy", "Díaz", "555444666", 1),
                Contacto("Alicia", "Díaz", "222111333", 1),
                Contacto("María", "Rivero", "678456123", 1),
                Contacto("Alberto", "Barrera", "644789456", 0),
                Contacto("Khaled", "García", "123456789", 0),
                Contacto("Ted", "Kaczynski", "987654321", 1),
                Contacto("Vera", "Almellones", "111111111", 1),
                Contacto("Gon", "Freecs", "999777888", 0),
                Contacto("Toji", "Fushiguro", "555444666", 0),
                Contacto("Jolyne", "Kujo", "222111333", 1),
                Contacto("Maki", "Zen'in", "693882147", 1)
            )
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "Inicio"
            ) {
                composable("Inicio") { login(navController) }
                composable("contactos") { ItemList(navController) }
                composable("add") { addContacto(navController) }
            }
        }
    }
}

