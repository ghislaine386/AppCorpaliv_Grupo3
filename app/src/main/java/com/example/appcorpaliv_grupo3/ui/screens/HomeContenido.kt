package com.example.appcorpaliv_grupo3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

// Texto institucional que se reutiliza en las tres versiones de HomeScreen
@Composable
fun InfoInstitucional() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = "CORPALIV · Alba Lab",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Promovemos la autonomía, participación e inclusión social y laboral de personas con discapacidad múltiple.",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "A través de la Escuela Especial Jan Van Dijk y la Red Sociolaboral Alba Lab desarrollamos programas de formación, preparación para el empleo y producción y comercialización de productos.",
            style = MaterialTheme.typography.bodyMedium
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "¿Cómo puedes colaborar?",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    text = "Con donaciones, alianzas con empresas, voluntariado, compra de productos con impacto social o capacitaciones. Conoce nuestros programas y deja tu interés en la sección Contacto.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }
    }
}