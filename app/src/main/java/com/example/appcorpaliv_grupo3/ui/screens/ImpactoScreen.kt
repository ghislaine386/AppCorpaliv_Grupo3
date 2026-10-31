package com.example.appcorpaliv_grupo3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appcorpaliv_grupo3.navigation.Screen
import com.example.appcorpaliv_grupo3.viewmodel.MainViewModel

@Composable
fun ImpactoScreen(viewModel: MainViewModel) {
    Scaffold(
        bottomBar = { BarraInferior(viewModel, Screen.Impacto) }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Casos de impacto")
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { viewModel.navigateTo(Screen.Inicio) }) {
                Text("Volver al inicio")
            }
        }
    }
}