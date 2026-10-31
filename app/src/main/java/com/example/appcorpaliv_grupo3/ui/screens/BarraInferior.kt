package com.example.appcorpaliv_grupo3.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.appcorpaliv_grupo3.navigation.Screen
import com.example.appcorpaliv_grupo3.viewmodel.MainViewModel

// Barra de navegación inferior compartida: Inicio, Programas y Catálogo.
// "seleccionado" indica en cuál pantalla estamos, para resaltar ese ítem.
@Composable
fun BarraInferior(viewModel: MainViewModel, seleccionado: Screen) {
    val items = listOf(Screen.Inicio, Screen.Programas, Screen.Catalogo)
    val labels = listOf("Inicio", "Programas", "Catálogo")
    val icons = listOf(Icons.Default.Home, Icons.Default.Info, Icons.Default.ShoppingCart)

    NavigationBar {
        items.forEachIndexed { index, screen ->
            NavigationBarItem(
                selected = screen == seleccionado,
                onClick = {
                    // Si ya estamos en esa pantalla, no hace nada
                    if (screen != seleccionado) viewModel.navigateTo(screen)
                },
                label = { Text(labels[index]) },
                icon = { Icon(icons[index], contentDescription = labels[index]) }
            )
        }
    }
}