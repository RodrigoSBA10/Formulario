package com.example.formulario.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed interface UIText {
    data class CadenaDinamica(val cadena: String) : UIText
    class RecursoCadena(
        @StringRes val id: Int,
        vararg val argumentos: Any
    ): UIText
    @Composable
    fun asString(): String{
        return when(this){
            is CadenaDinamica -> cadena
            is RecursoCadena -> stringResource(id, *argumentos)
        }
    }
}
