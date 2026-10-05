package com.example.appcorpaliv_grupo3.ui.screens

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import com.example.appcorpaliv_grupo3.ui.utils.obtenerWindowSizeClass

// Archivo principal: identifica el tamaño del dispositivo y elige la vista
@Composable
fun HomeScreen() {
    val windowSizeClass = obtenerWindowSizeClass()
    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> HomeScreenCompacta()
        WindowWidthSizeClass.Medium -> HomeScreenMediana()
        else -> HomeScreenExpandida()
    }
}