package com.example.stockeasy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.stockeasy.ui.theme.StockEasyTheme
import com.example.stockeasy.viewmodel.StockEasyViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos el ViewModel manualmente
        val viewModel = ViewModelProvider(this)[StockEasyViewModel::class.java]

        setContent {
            StockEasyTheme {
                AppNavigator(viewModel)
            }
        }
    }
}
