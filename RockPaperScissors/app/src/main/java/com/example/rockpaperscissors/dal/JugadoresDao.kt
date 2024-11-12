package com.example.rockpaperscissors.dal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface JugadoresDao {
    @Query("SELECT * FROM jugadores")
    suspend fun getTodo(): List<JugadorEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(jugador: JugadorEntity): Long

    @Update
    suspend fun  actualizar(jugador: JugadorEntity)

    @Query("SELECT * FROM jugadores WHERE id = :idJugador")
    suspend fun getJugadorPorId(idJugador: Long): JugadorEntity

}