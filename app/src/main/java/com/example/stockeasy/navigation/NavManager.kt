package com.example.stockeasy

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.stockeasy.screens.*
import com.example.stockeasy.viewmodel.StockEasyViewModel

@Composable
fun AppNavigator(viewModel: StockEasyViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("home") },
                onNavigateToRegister = { navController.navigate("register") }
            )
        }

        composable("register") {
            RegistroPantalla(
                onRegisterSuccess = { navController.navigate("home") },
                onNavigateToLogin = { navController.navigate("login") }
            )
        }

        composable("home") {
            PantallaPrincipal(navController = navController)
        }

        composable("productoNuevo") {
            ProductoNuevo(
                viewModel = viewModel,
                onProductoGuardado = { navController.popBackStack() }
            )
        }

        composable("crearLista") {
            CrearListaScreen(
                viewModel = viewModel,
                onListaCreada = { navController.popBackStack() }
            )
        }

        composable("inventario") {
            InventarioScreen(viewModel = viewModel,
                navController = navController)
        }

        composable("listas") {
            ListasScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

        composable("menuOpciones") {
            MenuOpciones(
                onBackClick = { navController.popBackStack() },
                onHomeClick = { navController.navigate("home") },
                onListasClick = { navController.navigate("inventario") },
                onAgregarClick = { navController.navigate("productoNuevo") },
                onConocenosClick = { /* futuro */ }
            )
        }

        // 🚀 NUEVA RUTA: NombreListaScreen
        composable(
            route = "nombreLista/{listaId}",
            arguments = listOf(navArgument("listaId") { type = NavType.IntType })
        ) { backStackEntry ->
            val listaId = backStackEntry.arguments?.getInt("listaId")
            val lista = viewModel.listas.find { it.id == listaId }

            lista?.let {
                NombreListaScreen(
                    lista = it,
                    viewModel = viewModel,
                    onSalirClick = { navController.popBackStack() },
                    onEditarClick = { /* agregar funcionalidad si se desea */ }
                )
            }
        }
    }
}
