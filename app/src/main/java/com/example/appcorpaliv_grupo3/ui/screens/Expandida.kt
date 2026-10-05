package com.example.appcorpaliv_grupo3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcorpaliv_grupo3.R
import com.example.appcorpaliv_grupo3.ui.theme.AppCorpaliv_Grupo3Theme

// EXPANDIDA (tablet grande/escritorio): dos paneles con tarjetas
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenExpandida() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi App Kotlin") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        Row(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(32.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            // Panel izquierdo: identidad
            Column(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo de la aplicación",
                    modifier = Modifier.fillMaxWidth().height(280.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "¡Bienvenido!",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            // Panel derecho: tarjetas y acción
            Column(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    listOf("Opción 1", "Opción 2", "Opción 3").forEach { titulo ->
                        Card(
                            modifier = Modifier.weight(1f),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer
                            )
                        ) {
                            Text(
                                text = titulo,
                                modifier = Modifier.fillMaxWidth().padding(vertical = 28.dp),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                    Text("Presióname")
                }
            }
        }
    }
}

@Preview(name = "Expanded", widthDp = 1000, heightDp = 700, showBackground = true)
@Composable
fun PreviewExpanded() {
    AppCorpaliv_Grupo3Theme { HomeScreenExpandida() }
}