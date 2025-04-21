package com.example.stockeasy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockeasy.R

@Composable
fun InventarioScreen() {
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
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Con StockEasy puedes agregar listas de tus inventarios personales y empresariales para tener un control sobre tus pertenencias",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Justify
        )

        Spacer(modifier = Modifier.height(24.dp))

        repeat(3) {
            Surface(
                color = Color.White,
                shape = RoundedCornerShape(12.dp),
                shadowElevation = 2.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                ListItem(
                    headlineContent = { Text("Listas") },
                    supportingContent = { Text("Descripción") },
                    trailingContent = {
                        IconButton(
                            onClick = { /* Acción para el botón siguiente */ },
                            modifier = Modifier.size(35.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.siguiente),
                                contentDescription = "Siguiente",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(12.dp)) // Separación entre listas
        }


        Button(
            onClick = { /* Acción agregar */ },
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


