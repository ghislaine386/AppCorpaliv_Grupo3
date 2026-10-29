package com.example.appcorpaliv_grupo3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.appcorpaliv_grupo3.navigation.Screen
import com.example.appcorpaliv_grupo3.viewmodel.ContactoViewModel
import com.example.appcorpaliv_grupo3.viewmodel.MainViewModel

@Composable
fun ContactoScreen(
    viewModel: MainViewModel,
    contactoViewModel: ContactoViewModel
) {
    val estado by contactoViewModel.estado.collectAsState()
    val tipos = listOf("Donación", "Alianza", "Voluntariado", "Compra de productos", "Capacitación")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Quiero colaborar", style = MaterialTheme.typography.headlineSmall)
        Text("Para probar, usa solo datos ficticios.", style = MaterialTheme.typography.bodySmall)

        OutlinedTextField(
            value = estado.nombre,
            onValueChange = contactoViewModel::onNombreChange,
            label = { Text("Nombre o institución") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            trailingIcon = {
                if (estado.errores.nombre != null) Icon(Icons.Default.Warning, contentDescription = "Error")
            },
            isError = estado.errores.nombre != null,
            supportingText = { estado.errores.nombre?.let { Text(it) } },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = estado.correo,
            onValueChange = contactoViewModel::onCorreoChange,
            label = { Text("Correo electrónico") },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
            trailingIcon = {
                if (estado.errores.correo != null) Icon(Icons.Default.Warning, contentDescription = "Error")
            },
            isError = estado.errores.correo != null,
            supportingText = { estado.errores.correo?.let { Text(it) } },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Text("Tipo de colaboración", style = MaterialTheme.typography.titleSmall)
        tipos.forEach { tipo ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = estado.tipoColaboracion == tipo,
                    onClick = { contactoViewModel.onTipoColaboracionChange(tipo) }
                )
                Text(tipo)
            }
        }
        estado.errores.tipoColaboracion?.let {
            Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
        }

        OutlinedTextField(
            value = estado.mensaje,
            onValueChange = contactoViewModel::onMensageChange,
            label = { Text("Mensaje") },
            leadingIcon = { Icon(Icons.Default.Edit, contentDescription = null) },
            trailingIcon = {
                if (estado.errores.mensaje != null) Icon(Icons.Default.Warning, contentDescription = "Error")
            },
            isError = estado.errores.mensaje != null,
            supportingText = { estado.errores.mensaje?.let { Text(it) } },
            minLines = 3,
            modifier = Modifier.fillMaxWidth()
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = estado.aceptaTerminos,
                onCheckedChange = contactoViewModel::onAceptaTerminos
            )
            Text("Acepto el uso de mis datos para ser contactado")
        }
        estado.errores.terminos?.let {
            Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
        }

        Button(
            onClick = {
                if (contactoViewModel.validarFormulario()) {
                    viewModel.navigateTo(Screen.Resumen)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar")
        }
    }
}