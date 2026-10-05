package com.example.appcorpaliv_grupo3.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcorpaliv_grupo3.ui.theme.AppCorpaliv_Grupo3Theme
import com.example.appcorpaliv_grupo3.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    // Scaffold: estructura base de la pantalla (barra superior + contenido)
    Scaffold(
        topBar = {
            // Barra superior con colores del MaterialTheme
            TopAppBar(
                title = { Text("Mi App Kotlin") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->

        // Column: apila los elementos verticalmente
        Column(
            modifier = Modifier
                .padding(innerPadding)          // respeta el espacio de la barra superior
                .fillMaxSize()                                 // ocupa toda la pantalla
                .padding(16.dp),                          // margen interno
            verticalArrangement = Arrangement.spacedBy(20.dp), // espaciado uniforme
            horizontalAlignment = Alignment.CenterHorizontally // centra los elementos
        ) {

            // Texto de bienvenida con color del tema
            Text(
                text = "¡Bienvenido!",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )

            // Botón (acción futura)
            Button(onClick = { /* acción futura */ }) {
                Text("Presióname")
            }

            // Imagen: ancho completo y altura fija
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo de CORPALIV",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )

            // --- Elemento nuevo (Parte 2, punto 8) ---
            // Row: dos botones en horizontal con espacio uniforme
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(onClick = { /* acción futura */ }) {
                    Text("Aceptar")
                }
                OutlinedButton(onClick = { /* acción futura */ }) {
                    Text("Cancelar")
                }
            }
        }
    }
}

// Vista previa en Android Studio
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AppCorpaliv_Grupo3Theme {
        HomeScreen()
    }
}