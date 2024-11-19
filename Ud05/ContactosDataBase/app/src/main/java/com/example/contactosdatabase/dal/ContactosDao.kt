package com.example.contactosdatabase.dal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactosDao {
    @Query("SELECT * FROM contactos")
    suspend fun getTodo(): List<ContactoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(contacto: ContactoEntity): Long

    @Update
    suspend fun actualizar (contacto: ContactoEntity)
}