package com.example.appcorpaliv_grupo3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.appcorpaliv_grupo3.R

// COMPACTA (celular): todo apilado en una columna con scroll
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenCompacta() {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())   // permite desplazar si el texto no cabe
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¡Bienvenido!",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo de la aplicación",
                modifier = Modifier.fillMaxWidth().height(150.dp),
                contentScale = ContentScale.Fit
            )
            InfoInstitucional()   // texto institucional compartido
            Button(onClick = {}) { Text("Quiero colaborar") }
        }
    }
}