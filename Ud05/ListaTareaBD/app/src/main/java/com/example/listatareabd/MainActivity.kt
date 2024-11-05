package com.example.listatareabd

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.listatareabd.ui.theme.ListaTareaBDTheme
import com.example.listatareabd.dal.TareasDataBase
import com.example.listatareabd.ui.views.miApp

class MainActivity : ComponentActivity() {
    companion object{
        lateinit var database: TareasDataBase
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(
            applicationContext,
            TareasDataBase::class.java,
            "tareas-db"
        ).build()
        enableEdgeToEdge()
        setContent {
            miApp()
        }
    }
}
