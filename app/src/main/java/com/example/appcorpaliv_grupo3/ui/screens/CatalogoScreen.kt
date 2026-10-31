package com.example.appcorpaliv_grupo3.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appcorpaliv_grupo3.R
import com.example.appcorpaliv_grupo3.navigation.Screen
import com.example.appcorpaliv_grupo3.viewmodel.MainViewModel

// Un elemento del catálogo: nombre, descripción y la foto (recurso de res/drawable)
private data class ItemCatalogo(
    val nombre: String,
    val descripcion: String,
    @DrawableRes val imagen: Int
)

// Datos de ejemplo ficticios. Cambia R.drawable.logo por el nombre de tu foto.
private val muestra = listOf(
    ItemCatalogo("Velas artesanales", "Elaboradas en el taller de producción de Alba Lab.", R.drawable.vela),
    ItemCatalogo("Tarjetas pintadas a mano", "Set de tarjetas únicas para saludos y regalos.", R.drawable.tarjeta),
    ItemCatalogo("Capacitación en inclusión laboral", "Taller para empresas sobre inclusión de personas con discapacidad.", R.drawable.capacitacion),
    ItemCatalogo("Adopta un taller", "Aporte mensual que apoya la formación de los participantes.", R.drawable.taller)
)

@Composable
fun CatalogoScreen(viewModel: MainViewModel) {
    Scaffold(
        bottomBar = { BarraInferior(viewModel, Screen.Catalogo) }
    ) { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            Text(
                text = "Catálogo de productos y servicios",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(16.dp)
            )
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(muestra) { item ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer
                        )
                    ) {

                        Image(
                            painter = painterResource(id = item.imagen),
                            contentDescription = item.nombre,
                            modifier = Modifier.fillMaxWidth().height(160.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = item.nombre,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                            Text(
                                text = item.descripcion,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                    }
                }
            }
        }
    }
}