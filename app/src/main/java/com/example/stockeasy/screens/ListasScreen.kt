package com.example.stockeasy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stockeasy.viewmodel.StockEasyViewModel

@Composable
fun ListasScreen(viewModel: StockEasyViewModel, navController: NavController) {
    val verdeOscuro = Color(0xFF2E7D6D)
    val grisClaro = Color(0xFFF5F5F5)
    val listas = viewModel.listas

    LaunchedEffect(Unit) {
        viewModel.cargarListas()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grisClaro)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Listas",
            fontSize = 26.sp,
            color = verdeOscuro,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (listas.isEmpty()) {
            Text(
                text = "No hay listas registradas.",
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            listas.forEach { lista ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    ListItem(
                        headlineContent = { Text(lista.nombre) },
                        supportingContent = { Text(lista.descripcion) },
                        leadingContent = {
                            Icon(Icons.Default.List, contentDescription = null, tint = verdeOscuro)
                        },
                        trailingContent = {
                            Row {
                                IconButton(onClick = {
                                    viewModel.eliminarLista(lista)
                                }) {
                                    Icon(Icons.Default.Delete, contentDescription = "Eliminar", tint = Color.Red)
                                }
                            }
                        },
                        modifier = Modifier.clickable {
                            navController.navigate("nombreLista/${lista.id}")
                        }
                    )
                }
            }
        }
    }
}

/*@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListasScreenPreview() {
        ListasScreen()
}*/
