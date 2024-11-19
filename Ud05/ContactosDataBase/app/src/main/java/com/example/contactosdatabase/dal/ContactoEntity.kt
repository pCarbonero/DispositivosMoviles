package com.example.contactosdatabase.dal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactos")
data class ContactoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var nombre: String = "",
    var apellido: String = "",
    var telefono: Int = 0,
    var imagen: Int = 0
)
