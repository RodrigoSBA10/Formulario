package com.example.formulario.ui

import android.content.Context
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.formulario.R
import com.example.formulario.persistencia.ServicioDatos
import com.example.formulario.persistencia.Usuario


class InputViewModel(): ViewModel() {
    var nameField by mutableStateOf(FieldInput())
    val nameErrorStatus by derivedStateOf { validateName(nameField.valor) }

    var emailField by mutableStateOf(FieldInput())

    val emailErrorStatus by derivedStateOf { validateEmail(emailField.valor) }

    val listaUsuarios by derivedStateOf { obtenerLista() }
    lateinit var contexto: Context

    fun validateName(name: String): ErrorStatus{
        return when{
            name.trim().isEmpty() -> {
                ErrorStatus(true, UIText.RecursoCadena(R.string.requerido))
            }else->{
                ErrorStatus(false)
            }
        }
    }

    fun asignarContexto(contex: Context){
        contexto = contex
    }

    fun obtenerLista(): List<Usuario>{
        val servicio = ServicioDatos(contexto)
        return servicio.obtenerUsuarios()
    }

    fun validateEmail(email: String): ErrorStatus {
        val emailPattern = Regex("[a-zA-Z\\d._-]+@[a-z]+\\.+[a-z]+")
        return when {
            email.trim().isEmpty() -> {
                ErrorStatus(true, UIText.RecursoCadena(R.string.requerido))
            }

            !email.trim().matches(emailPattern) -> {
                ErrorStatus(true, UIText.RecursoCadena(R.string.email))
            }

            else -> {
                ErrorStatus(false)
            }
        }
    }
}

