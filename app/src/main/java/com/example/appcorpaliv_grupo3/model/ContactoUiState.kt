package com.example.appcorpaliv_grupo3.model


data class ContactoErrores(
    val nombre: String? = null,
    val correo: String? = null,
    val tipoColaboracion: String? = null,
    val mensaje: String? = null,
    val terminos: String? = null
)


data class ContactoUiState (
    val nombre: String = "",
    val correo: String = "",
    val tipoColaboracion: String = "",
    val mensaje: String = "",
    val aceptaTerminos: Boolean = false,
    val errores: ContactoErrores = ContactoErrores()
)
