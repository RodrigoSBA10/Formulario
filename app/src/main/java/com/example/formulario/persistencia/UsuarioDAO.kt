package com.example.formulario.persistencia

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDAO {
    @Query("SELECT * FROM usuario")
    fun getAll(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Usuario>

    @Query("SELECT *  FROM usuario WHERE nombres LIKE :nombre AND email LIKE :email LIMIT 1")
    fun findByNameAndEmail(nombre: String, email: String ): Usuario

    @Insert
    fun insertAll(vararg usuarios: Usuario)

    @Delete
    fun delete(user: Usuario)
}