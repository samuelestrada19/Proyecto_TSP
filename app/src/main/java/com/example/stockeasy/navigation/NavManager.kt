package com.example.stockeasy

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stockeasy.screens.PantallaPrincipal
import com.example.stockeasy.screens.ProductoNuevo
import com.example.stockeasy.screens.LoginScreen
import com.example.stockeasy.screens.RegistroPantalla

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
            PantallaPrincipal(navController = navController)  // Navega a la pantalla principal
        }
        composable("productoNuevo") {
            ProductoNuevo()  // Navega a la pantalla de agregar producto
        }
    }
}
