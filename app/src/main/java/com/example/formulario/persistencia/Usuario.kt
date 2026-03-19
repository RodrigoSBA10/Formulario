package com.example.formulario.persistencia

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario (
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    @ColumnInfo(name = "nombres") val nombre: String?,
    @ColumnInfo(name = "email") val correo: String?
)