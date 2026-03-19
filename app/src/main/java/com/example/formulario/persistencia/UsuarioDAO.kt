package com.example.formulario.persistencia

import android.provider.ContactsContract
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


interface UsuarioDAO {
    @Query("SELECT * FROM usuario")
    fun getAll(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Usuario>

    @Query("SELECT *  FROM usuario WHERE nombres LIKE :nombre AND email LIKE :email LIMIT 1")
    fun findByNameAndEmail(nombre: String, email: String )

    @Insert
    fun insertAll(vararg usuarios: Usuario)

    @Delete
    fun delete(user: Usuario)
}