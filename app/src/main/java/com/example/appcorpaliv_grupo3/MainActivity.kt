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
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
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
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                val destinos = listOf(Screen.Inicio, Screen.Programas, Screen.Catalogo, Screen.Impacto, Screen.Contacto)
                val etiquetas = listOf("Inicio", "Programas", "Catálogo", "Impacto", "Contacto")

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Text("Menú", modifier = Modifier.padding(16.dp))
                            destinos.forEachIndexed { index, screen ->
                                NavigationDrawerItem(
                                    label = { Text(etiquetas[index]) },
                                    selected = false,
                                    onClick = {
                                        scope.launch { drawerState.close() }
                                        viewModel.navigateTo(screen)
                                    }
                                )
                            }
                        }
                    }
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text("CORPALIV · Alba Lab") },
                                navigationIcon = {
                                    IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                        Icon(Icons.Default.Menu, contentDescription = "Menú")
                                    }

                                }
                            )

                        }
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Inicio.route,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable(Screen.Inicio.route) { HomeScreen() }
                            composable(Screen.Programas.route) { ProgramaScreen(viewModel) }
                            composable(Screen.Catalogo.route) { CatalogoScreen(viewModel) }
                            composable(Screen.Impacto.route) { ImpactoScreen(viewModel) }
                            composable(Screen.Contacto.route) { ContactoScreen(viewModel) }
                        }
                    }
                }
            }
        }
    }
}