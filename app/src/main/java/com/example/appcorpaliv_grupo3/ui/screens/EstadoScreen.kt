package com.example.appcorpaliv_grupo3.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.appcorpaliv_grupo3.viewmodel.EstadoViewModel

@Composable
fun EstadoScreen(viewModel: EstadoViewModel, modifier: Modifier = Modifier) {

    // Observamos el estado y el mensaje desde el ViewModel
    val estado by viewModel.activo.collectAsState()
    val mostrarMensaje by viewModel.mostrarMensaje.collectAsState()
    val cargado = estado

    if (cargado == null) {
        //  loader mientras se carga el estado guardado
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        //  el color cambia con animación según el estado
        val colorAnimado by animateColorAsState(
            targetValue = if (cargado) Color(0xFF4CAF50) else Color(0xFFB0BEC5),
            animationSpec = tween(durationMillis = 500),
            label = "colorBoton"
        )

        // texto del botón derivado del estado
        val textoBoton by remember(cargado) {
            derivedStateOf { if (cargado) "Desactivar" else "Activar" }
        }

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Tarjeta que cambia de color y se redimensiona suavemente
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(),
                colors = CardDefaults.cardColors(
                    containerColor = colorAnimado.copy(alpha = 0.25f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("Modo accesible", style = MaterialTheme.typography.titleLarge)

                    // El texto de estado cambia con una transición de fundido
                    AnimatedContent(
                        targetState = cargado,
                        transitionSpec = { fadeIn(tween(400)) togetherWith fadeOut(tween(400)) },
                        label = "textoEstado"
                    ) { activo ->
                        Text(
                            text = if (activo) "Texto grande: ACTIVADO" else "Texto grande: DESACTIVADO",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center
                        )
                    }

                    // Descripción que aparece solo cuando el modo está activo
                    AnimatedVisibility(visible = cargado) {
                        Text(
                            text = "Letra ampliada en toda la app para facilitar la lectura.",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón que alterna el estado y lo guarda en DataStore
            Button(
                onClick = { viewModel.alternarEstado() },
                colors = ButtonDefaults.buttonColors(containerColor = colorAnimado),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(textoBoton, style = MaterialTheme.typography.titleLarge)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // mensaje de éxito con animación de entrada y salida
            AnimatedVisibility(
                visible = mostrarMensaje,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut()
            ) {
                Text(
                    text = "¡Preferencia guardada exitosamente!",
                    color = Color(0xFF4CAF50),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}