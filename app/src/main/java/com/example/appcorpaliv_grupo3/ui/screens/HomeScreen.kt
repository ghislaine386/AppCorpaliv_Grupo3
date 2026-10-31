package com.example.appcorpaliv_grupo3.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.appcorpaliv_grupo3.navigation.Screen
import com.example.appcorpaliv_grupo3.ui.utils.obtenerWindowSizeClass
import com.example.appcorpaliv_grupo3.viewmodel.MainViewModel

// Archivo principal: identifica el tamaño del dispositivo y elige la vista
@Composable
fun HomeScreen(viewModel: MainViewModel) {
    val windowSizeClass = obtenerWindowSizeClass()

    Scaffold(
        bottomBar = { BarraInferior(viewModel, Screen.Inicio) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (windowSizeClass.widthSizeClass) {
                WindowWidthSizeClass.Compact -> HomeScreenCompacta()
                WindowWidthSizeClass.Medium -> HomeScreenMediana()
                else -> HomeScreenExpandida()
            }
        }
    }
}