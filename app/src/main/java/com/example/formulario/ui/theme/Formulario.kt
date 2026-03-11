package com.example.formulario.ui.theme

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.formulario.ui.ErrorStatus
import com.example.formulario.ui.FieldInput

@Composable
fun OutlinedTextFieldWithSate(
    modifier: Modifier, label: String, fielfInput: FieldInput, errorStatus: ErrorStatus,
    KeyBoardType: KeyboardOptions, isPasswordField: Boolean = false, keyBoardAction: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit
) {
    var passwordVisibility by remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = modifier, value = fielfInput.valor, onValueChange = { onValueChange(it) }
    )
}