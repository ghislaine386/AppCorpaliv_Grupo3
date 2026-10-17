package com.example.appcorpaliv_grupo3.navigation

sealed class Screen(val route : String){
    data object Inicio : Screen (route = "inicio_page")
    data object Programas : Screen(route = "programas_page")
    data object Catalogo : Screen (route = "catalogo_page")
    data object Impacto : Screen (route = "impacto_page")
    data object Contacto : Screen (route = "contacto_page")
    data object Resumen : Screen(route = "resumen_page")
}