package com.example.stockeasy

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stockeasy.screens.*

@Composable
fun AppNavigator() {
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
            ProductoNuevo()
        }
        composable("inventario") {
            InventarioScreen()
        }
        composable("menuOpciones") {
            MenuOpciones(
                onBackClick = { navController.popBackStack() },
                onHomeClick = { navController.navigate("home") },
                onListasClick = { navController.navigate("inventario") },
                onAgregarClick = { navController.navigate("productoNuevo") },
                onConocenosClick = { /* acción futura */ }
            )
        }
    }
}
