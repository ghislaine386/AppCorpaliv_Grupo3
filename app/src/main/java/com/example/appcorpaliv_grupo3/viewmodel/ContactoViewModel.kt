package com.example.appcorpaliv_grupo3.viewmodel


import androidx.lifecycle.ViewModel
import com.example.appcorpaliv_grupo3.model.ContactoErrores
import com.example.appcorpaliv_grupo3.model.ContactoUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ContactoViewModel : ViewModel (){

    //estado interno que solo el viewmodel modifica
    private val _estado = MutableStateFlow(ContactoUiState())
    //estado expuesto a la pantalla (solo lectura)
    val estado: StateFlow<ContactoUiState> = _estado

    fun onNombreChange(valor: String) {
        _estado.update { it.copy(nombre = valor, errores = it.errores.copy(nombre = null)) }

    }

    fun onCorreoChange(valor: String) {
        _estado.update { it.copy(correo = valor, errores = it.errores.copy(correo = null)) }
    }

    fun onTipoColaboracionChange(valor: String){
        _estado.update { it.copy(tipoColaboracion = valor, errores = it.errores.copy(tipoColaboracion = null)) }
    }

    fun onMensageChange(valor: String){
        _estado.update { it.copy(mensaje = valor, errores = it.errores.copy(mensaje = null)) }
    }

    fun onAceptaTerminos(valor: Boolean) {
        _estado.update { it.copy(aceptaTerminos = valor , errores = it.errores.copy(terminos = null)) }
    }

    fun validarFormulario(): Boolean {
        val actual = _estado.value
        val regexCorreo = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

        val errores = ContactoErrores(
            nombre = if (actual.nombre.trim().length < 3) "Ingresa tu nombre o institución (mínimo 3 letras)" else null,
            correo = if (!regexCorreo.matches(actual.correo.trim())) "Ingresa un correo válido" else null,
            tipoColaboracion = if (actual.tipoColaboracion.isBlank()) "Elige un tipo de colaboración" else null,
            mensaje = if (actual.mensaje.trim().length < 10) "El mensaje debe tener al menos 10 caracteres" else null,
            terminos = if (!actual.aceptaTerminos) "Debes aceptar los términos para continuar" else null
        )

        _estado.update { it.copy(errores = errores) }
        return errores == ContactoErrores()
    }
    // Deja el formulario de contacto vacío (nombre, correo, mensaje, etc.).
    // Se usa al volver al inicio, para que el próximo usuario no vea datos anteriores.
    fun limpiarFormulario() {
        _estado.value = ContactoUiState()
    }

}