package com.example.stockeasy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stockeasy.R
import com.example.stockeasy.viewmodel.StockEasyViewModel

@Composable
fun InventarioScreen(
    viewModel: StockEasyViewModel,
    navController: NavController
) {
    val listas = viewModel.listas

    // Cargar listas solo una vez
    LaunchedEffect(Unit) {
        viewModel.cargarListas()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = "Fondo",
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Agrega listas y crea tu inventario",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Con StockEasy puedes agregar listas de tus inventarios personales y empresariales para tener un control sobre tus pertenencias.",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Justify
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (listas.isEmpty()) {
            Text(
                text = "No hay listas creadas aún.",
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            listas.forEach { lista ->
                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(12.dp),
                    shadowElevation = 2.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable {
                            navController.navigate("nombreLista/${lista.id}")
                        }
                ) {
                    ListItem(
                        headlineContent = { Text(lista.nombre, fontWeight = FontWeight.Bold) },
                        supportingContent = { Text(lista.descripcion) },
                        trailingContent = {
                            IconButton(onClick = {
                                navController.navigate("nombreLista/${lista.id}")
                            }) {
                                Image(
                                    painter = painterResource(id = R.drawable.siguiente),
                                    contentDescription = "Siguiente",
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("crearLista") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D6D)),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.5f)
        ) {
            Text("AGREGAR", color = Color.White)
        }
    }
}
