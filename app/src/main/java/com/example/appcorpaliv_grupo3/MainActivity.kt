package com.example.appcorpaliv_grupo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcorpaliv_grupo3.navigation.NavigationEvent
import com.example.appcorpaliv_grupo3.navigation.Screen
import com.example.appcorpaliv_grupo3.ui.screens.CatalogoScreen
import com.example.appcorpaliv_grupo3.ui.screens.ContactoScreen
import com.example.appcorpaliv_grupo3.ui.screens.HomeScreen
import com.example.appcorpaliv_grupo3.ui.screens.ImpactoScreen
import com.example.appcorpaliv_grupo3.ui.screens.ProgramaScreen
import com.example.appcorpaliv_grupo3.ui.theme.AppCorpaliv_Grupo3Theme
import com.example.appcorpaliv_grupo3.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCorpaliv_Grupo3Theme {
                val viewModel: MainViewModel = viewModel()
                val navController = rememberNavController()

                LaunchedEffect(Unit) {
                    viewModel.navigationEvents.collectLatest { event ->
                        when (event) {
                            is NavigationEvent.NavigateTo -> {
                                navController.navigate(event.route.route){
                                    event.popUpToRoute?.let {
                                        popUpTo(it.route) { inclusive = event.inclusive}
                                    }
                                    launchSingleTop = event.singleTop
                                    restoreState = true
                                }
                            }
                            is NavigationEvent.PopBackStack -> navController.popBackStack()
                            is NavigationEvent.NavigateUp -> navController.navigateUp()
                        }
                    }
                }

                NavHost(
                    navController = navController,
                    startDestination = Screen.Programas.route
                ) {
                    composable(Screen.Inicio.route) { HomeScreen() }
                    composable(Screen.Programas.route) { ProgramaScreen(viewModel)}
                    composable(Screen.Catalogo.route) { CatalogoScreen(viewModel) }
                    composable(Screen.Impacto.route) { ImpactoScreen(viewModel) }
                    composable(Screen.Contacto.route) { ContactoScreen(viewModel) }
                }
            }
        }
    }
}