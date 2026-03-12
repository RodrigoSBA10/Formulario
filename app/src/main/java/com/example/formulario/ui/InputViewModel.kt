package com.example.formulario.ui

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.formulario.R


class InputViewModel: ViewModel() {
    var nameField by mutableStateOf(FieldInput())
    val nameErrorStatus by derivedStateOf { validateName(nameField.valor) }

    fun validateName(name: String): ErrorStatus{
        return when{
            name.trim().isEmpty() -> {
                ErrorStatus(true, UIText.RecursoCadena(R.string.requerido))
            }else->{
                ErrorStatus(false)
            }
        }

    }
}

