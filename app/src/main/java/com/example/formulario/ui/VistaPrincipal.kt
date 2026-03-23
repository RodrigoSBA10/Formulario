package com.example.formulario.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.formulario.persistencia.ServicioDatos
import com.example.formulario.persistencia.Usuario



@Composable
fun ListaContactosScreen(context: Context){
    val context = LocalContext.current
    val inputViewModel: InputViewModel = viewModel()
    inputViewModel.asignarContexto(context)
    LazyColumn {
        items(inputViewModel.listaUsuarios){
            usuario -> UsuarioItem(usuario = usuario){
        }
        }
    }
}

@Composable
fun DetallesUsuarioScreen(usuarioId: Int?, onBack: ()-> Unit){
    val context = LocalContext.current
    val inputViewModel: InputViewModel = viewModel()
    inputViewModel.asignarContexto(context)
    val usuario = inputViewModel.listaUsuarios.find { it.id == usuarioId }
    Column() {
        IconButton(onClick = onBack) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Regresar")
        }
        Text("${usuario?.nombre}")
        Text("${usuario?.correo}")

    }
}

@Composable
fun UsuarioItem(usuario: Usuario, onClick:() -> Unit ){
    Card(modifier = Modifier.fillMaxWidth()
        .padding(8.dp).clickable{onClick()},
        elevation = CardDefaults.cardElevation(4.dp)) {
        Row(modifier = Modifier.padding(16.dp)) {
            Box(modifier = Modifier.size(40.dp).background(Color.LightGray, CircleShape)
                , contentAlignment = Alignment.Center
            ){
                Text("${usuario.nombre}")
            }
            Spacer(Modifier.width(16.dp))
            Text("${usuario.correo}", style = MaterialTheme.typography.bodySmall)
        }
    }
}





















