package com.example.rockpaperscissors.dal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jugadores")
data class JugadorEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var nombre: String = "",
    var partidasGanadas: Int = 0,
    var duelosGanados: Int = 0
)
