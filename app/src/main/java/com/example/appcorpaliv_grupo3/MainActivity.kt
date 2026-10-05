package com.example.appcorpaliv_grupo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appcorpaliv_grupo3.ui.screens.HomeScreen
import com.example.appcorpaliv_grupo3.ui.theme.AppCorpaliv_Grupo3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCorpaliv_Grupo3Theme {
                HomeScreen() // muestra la pantalla creada en ui/HomeScreen.kt
            }
        }
    }
}