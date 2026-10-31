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
import com.example.appcorpaliv_grupo3.ui.screens.EstadoScreen
import com.example.appcorpaliv_grupo3.ui.screens.LoginScreen
import com.example.appcorpaliv_grupo3.viewmodel.EstadoViewModel
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
import com.example.appcorpaliv_grupo3.viewmodel.ContactoViewModel
import kotlinx.coroutines.launch
import com.example.appcorpaliv_grupo3.ui.screens.ResumenScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import com.example.appcorpaliv_grupo3.navigation.Screen.Impacto
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.activity.SystemBarStyle


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT))
        setContent {
            AppCorpaliv_Grupo3Theme {
                val viewModel: MainViewModel = viewModel()
                val contactoViewModel: ContactoViewModel = viewModel()
                val estadoViewModel: EstadoViewModel = viewModel()
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
                val destinos = listOf(Screen.Inicio, Screen.Contacto, Screen.Estado)
                val etiquetas = listOf("Inicio","Impacto", "Contacto", "Modo Accesible")

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            // Column ocupatodo el alto del menu para poder dejar el login abajo
                            Column(modifier = Modifier.fillMaxHeight()) {
                                Text("Menú", modifier = Modifier.padding(16.dp))
                                // opciones principales: se generan recorriendo las listas destinos y etiquetas
                                destinos.forEachIndexed { index, screen ->
                                    NavigationDrawerItem(
                                        label = { Text(etiquetas[index]) },
                                        selected = false,
                                        onClick = {
                                            scope.launch { drawerState.close() } // cierra el menu al elegir
                                            viewModel.navigateTo(screen) // el ViewModel emite el evento de navegacion
                                        }
                                    )
                                }

                                // Ocupa el espacio sobrante y empuja el login hacia el fondo del menu
                                Spacer(modifier = Modifier.weight(1f))

                                // Opcion de inicio de sesion: va aparte de la lista, abajo a la izquierda y con el logo
                                NavigationDrawerItem(
                                    label = { Text("Iniciar sesión") },
                                    icon = {
                                        Image(
                                            painter = painterResource(id = R.drawable.logo),
                                            contentDescription = "Logo CORPALIV",
                                            modifier = Modifier.size(28.dp)
                                        )
                                    },
                                    selected = false,
                                    onClick = {
                                        scope.launch { drawerState.close() }
                                        viewModel.navigateTo(Screen.Login)
                                    },
                                    modifier = Modifier.padding(bottom = 16.dp)
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
                                },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primary,          // fondo azul
                                    titleContentColor = MaterialTheme.colorScheme.onPrimary,     // título blanco
                                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary  // ícono hamburguesa blanco
                                )
                            )

                        }
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Inicio.route,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable(Screen.Inicio.route) { HomeScreen(viewModel) }
                            composable(Screen.Programas.route) { ProgramaScreen(viewModel) }
                            composable(Screen.Catalogo.route) { CatalogoScreen(viewModel) }
                            composable(Impacto.route) { ImpactoScreen(viewModel) }
                            composable(Screen.Contacto.route) { ContactoScreen(viewModel, contactoViewModel) }
                            composable(Screen.Resumen.route) { ResumenScreen(viewModel, contactoViewModel) }
                            composable(Screen.Estado.route) { EstadoScreen(estadoViewModel) }
                            // Ruta de la pantalla de inicio de sesion (se abre desde el menu lateral)
                            composable(Screen.Login.route) { LoginScreen(viewModel)}

                        }
                    }
                }
            }
        }
    }
}