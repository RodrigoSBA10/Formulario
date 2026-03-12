package com.example.formulario.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formulario.ui.ErrorStatus
import com.example.formulario.ui.FieldInput
import com.example.formulario.ui.InputViewModel
import com.example.formulario.R


@Composable
fun OutlinedTextFieldWithSate(
    modifier: Modifier, label: String, fielfInput: FieldInput, errorStatus: ErrorStatus,
    KeyBoardType: KeyboardOptions, isPasswordField: Boolean = false, keyBoardAction: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit
) {
    var passwordVisibility by remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = modifier, value = fielfInput.valor, onValueChange = { onValueChange(it)}, label = {Text(text = label, style = MaterialTheme.typography.bodyMedium)},
        singleLine = true, keyboardOptions = KeyBoardType,
        keyboardActions = keyBoardAction,
        isError = fielfInput.hasInterected && errorStatus.isError,
        supportingText = {
            if (fielfInput.hasInterected && errorStatus.isError) {
                errorStatus.errorMessage?.let {
                    Text(
                        text = it.asString(),
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    ) }

@Preview(showBackground = true)
@Composable
fun InputPreview() {
    val inputViewModel: InputViewModel = InputViewModel()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Center)
        ) {
            item {
                OutlinedTextFieldWithSate(
                    modifier = Modifier.fillMaxSize(), label = stringResource(id = R.string.nombre),
                    fielfInput = inputViewModel.nameField, errorStatus = inputViewModel.nameErrorStatus,
                    KeyBoardType = KeyboardOptions(keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.Words,
                        imeAction = ImeAction.Next),
                    ){
                    inputViewModel.nameField = inputViewModel.nameField.copy(
                        valor = it,
                        hasInterected = true
                    )
                }
            }
        }
    }
}