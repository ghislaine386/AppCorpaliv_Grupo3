package com.example.appcorpaliv_grupo3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcorpaliv_grupo3.navigation.NavigationEvent
import com.example.appcorpaliv_grupo3.navigation.Screen
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val _navigationEvents = MutableSharedFlow<NavigationEvent>()
    val navigationEvents: SharedFlow<NavigationEvent> = _navigationEvents.asSharedFlow()

    // Envía un evento de navegación a MainActivity.
    // Los parámetros extra son opcionales (tienen valor por defecto),
    // así que las llamadas antiguas como navigateTo(Screen.Inicio) siguen funcionando.
    fun navigateTo(
        screen: Screen,                  // pantalla de destino
        popUpToRoute: Screen? = null,    // hasta qué pantalla se borra el historial (null = no borra nada)
        inclusive: Boolean = false,      // true = también borra esa pantalla del historial
        singleTop: Boolean = false       // true = evita abrir la misma pantalla dos veces seguidas
    ) {
        viewModelScope.launch {
            _navigationEvents.emit(
                NavigationEvent.NavigateTo(
                    route = screen,
                    popUpToRoute = popUpToRoute,
                    inclusive = inclusive,
                    singleTop = singleTop
                )
            )
        }
    }
    fun navigateBack(){
        viewModelScope.launch {
            _navigationEvents.emit(NavigationEvent.PopBackStack)
        }
    }

    fun navigateUp(){
        viewModelScope.launch {
            _navigationEvents.emit(NavigationEvent.NavigateUp)
        }
    }
}