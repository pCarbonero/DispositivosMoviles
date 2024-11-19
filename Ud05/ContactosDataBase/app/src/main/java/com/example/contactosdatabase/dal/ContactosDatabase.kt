package com.example.contactosdatabase.dal

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ContactoEntity::class], version = 1)
abstract class ContactosDatabase: RoomDatabase() {
    abstract fun contactoDao():ContactosDao
}