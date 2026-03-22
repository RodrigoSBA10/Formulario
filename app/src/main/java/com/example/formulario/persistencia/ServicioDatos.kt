package com.example.formulario.persistencia

import android.content.Context

class ServicioDatos(aplicationContext: Context) {
    val dataBase = AppDataBase.getDataBase(aplicationContext)
    val userDao = dataBase.usuarioDao()

    fun obtenerUsuarios(): List<Usuario>{
        val user: List<Usuario> = userDao.getAll()
        return user
    }

    fun obtenerUsuarioNombreEmail(nombre: String, email: String){
        val user = userDao.findByNameAndEmail(nombre, email)
    }

    fun agregarUsuario(usuario: Usuario){
        userDao.insertAll(usuario)
    }
}