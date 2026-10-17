package com.example.appcorpaliv_grupo3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appcorpaliv_grupo3.navigation.Screen
import com.example.appcorpaliv_grupo3.viewmodel.ContactoViewModel
import com.example.appcorpaliv_grupo3.viewmodel.MainViewModel

@Composable
fun ResumenScreen(
    viewModel: MainViewModel,
    contactoViewModel: ContactoViewModel
) {
    val estado by contactoViewModel.estado.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Resumen de tu solicitud", style = MaterialTheme.typography.headlineSmall)
        Text("Nombre o institución: ${estado.nombre}")
        Text("Correo: ${estado.correo}")
        Text("Tipo de colaboración: ${estado.tipoColaboracion}")
        Text("Mensaje: ${estado.mensaje}")
        Button(onClick = { viewModel.navigateTo(Screen.Inicio) }) {
            Text("Volver al inicio")
        }
    }
}