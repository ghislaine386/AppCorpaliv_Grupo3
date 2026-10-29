package com.example.appcorpaliv_grupo3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appcorpaliv_grupo3.navigation.Screen
import com.example.appcorpaliv_grupo3.viewmodel.MainViewModel

@Composable
fun LoginScreen(viewModel: MainViewModel){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Iniciar sesión",style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(24.dp))
        // Vuelve a la pantalla de inicio mediante el ViewModel
        Button(onClick = { viewModel.navigateTo(Screen.Inicio)}) {
            Text("Volver al inicio")
        }
    }
}