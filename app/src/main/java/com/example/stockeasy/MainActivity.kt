package com.example.stockeasy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.material3.*
import com.example.stockeasy.screens.ArticulosPantalla
import com.example.stockeasy.screens.LoginScreen
import com.example.stockeasy.screens.RegistroPantalla
import com.example.stockeasy.ui.theme.StockEasyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockEasyTheme {
                AppNavigator()
            }
        }
    }
}

@Composable
fun AppNavigator() {
    var currentScreen by remember { mutableStateOf("login") }

    when (currentScreen) {
        "login" -> LoginScreen(
            onLoginSuccess = { currentScreen = "home" },
            onNavigateToRegister = { currentScreen = "register" }
        )
        "register" -> RegistroPantalla(
            onRegisterSuccess = { currentScreen = "home" },
            onNavigateToLogin = { currentScreen = "login" }
        )
        "home" -> ArticulosPantalla()
    }
}
