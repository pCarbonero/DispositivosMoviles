package com.example.listatareabd.dal

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = [TareaEntity::class], version = 1)
abstract class TareasDataBase: RoomDatabase(){
    abstract fun tareaDao():TareasDao
}