package com.example.appcorpaliv_grupo3.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = AzulModoOscuro,
    onPrimary = AzulOscuro,
    secondary = VerdeModoOscuro,
    onSecondary = VerdeOscuro,
    tertiary = NaranjaModoOscuro
)

private val LightColorScheme = lightColorScheme(
    primary = AzulCorpaliv,
    onPrimary = Color.White,
    primaryContainer = AzulClaro,
    onPrimaryContainer = AzulOscuro,
    secondary = VerdeCorpaliv,
    onSecondary = Color.White,
    secondaryContainer = VerdeClaro,
    onSecondaryContainer = VerdeOscuro,
    tertiary = NaranjaCorpaliv,
    onTertiary = Color.White,
    tertiaryContainer = NaranjaClaro,
    background = FondoClaro,
    surface = FondoClaro
)

@Composable
fun AppCorpaliv_Grupo3Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // false = usa SIEMPRE la paleta de CORPALIV (no los colores del fondo del teléfono)
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}