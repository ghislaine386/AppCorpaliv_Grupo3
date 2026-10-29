package com.example.appcorpaliv_grupo3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appcorpaliv_grupo3.navigation.Screen
import com.example.appcorpaliv_grupo3.viewmodel.ContactoViewModel
import com.example.appcorpaliv_grupo3.viewmodel.MainViewModel
import kotlinx.coroutines.delay

@Composable
fun ResumenScreen(
    viewModel: MainViewModel,
    contactoViewModel: ContactoViewModel
) {
// Datos que el usuario escribió en el formulario (se actualizan solos en pantalla)
val estado by contactoViewModel.estado.collectAsState()

// Segundos que faltan para volver al inicio. Empieza en 15.
// Al cambiar su valor, Compose redibuja el texto del contador automáticamente.
var segundos by remember { mutableIntStateOf(15)}


// Limpia el formulario y vuelve al inicio, borrando Contacto y Resumen del historial
// (así el botón "atrás" no regresa al resumen).
fun volverAlInicio() {
  contactoViewModel.limpiarFormulario()
  viewModel.navigateTo(
     screen = Screen.Inicio,
     popUpToRoute = Screen.Inicio,
     inclusive = true
    )
}

// Temporizador: se inicia al abrir la pantalla y se cancela solo si el usuario
// se va antes (por el botón o por el menú).
    LaunchedEffect(Unit) {
        while (segundos >0){
            delay(1000) //1000 segundos
            segundos--  //baja el contador
        }
        //llego a 0 : vuelve al inicio automaticamente
        volverAlInicio()
    }


    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Resumen de tu solicitud", style = MaterialTheme.typography.headlineSmall)
        Text("Nombre o institución: ${estado.nombre}")
        Text("Correo: ${estado.correo}")
        Text("Tipo de colaboración: ${estado.tipoColaboracion}")
        Text("Mensaje: ${estado.mensaje}")

        // Aviso al usuario para que sepa que la pantalla se cerrará sola
        Text(
            "Volverás al inicio en $segundos segundos",
            style = MaterialTheme.typography.bodySmall
        )

        // Opción manual por si el usuario no quiere esperar los 15 segundos
        Button(onClick = { volverAlInicio() }) {
            Text("Volver al inicio ahora")
        }
    }
}