package com.example.appcorpaliv_grupo3.ui.screens

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
import com.example.appcorpaliv_grupo3.R
import com.example.appcorpaliv_grupo3.ui.theme.AppCorpaliv_Grupo3Theme

// MEDIANA (tablet pequeña): logo a la izquierda, texto y botones a la derecha
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenMediana() {
    Scaffold { innerPadding ->
        Row(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo de la aplicación",
                modifier = Modifier.weight(1f).height(250.dp),
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "¡Bienvenido!",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                InfoInstitucional()
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button(onClick = {}) { Text("Presióname") }
                    OutlinedButton(onClick = {}) { Text("Más info") }
                }
            }
        }
    }
}

@Preview(name = "Medium", widthDp = 700, heightDp = 900, showBackground = true)
@Composable
fun PreviewMedium() {
    AppCorpaliv_Grupo3Theme { HomeScreenMediana() }
}