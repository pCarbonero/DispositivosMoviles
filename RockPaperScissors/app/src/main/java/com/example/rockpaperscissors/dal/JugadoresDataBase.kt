package com.example.rockpaperscissors.dal

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = [JugadorEntity::class], version = 1)
abstract class JugadoresDataBase: RoomDatabase(){
    abstract fun jugadorDao():JugadoresDao
}