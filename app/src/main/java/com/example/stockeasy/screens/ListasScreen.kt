package com.example.stockeasy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockeasy.R

@Composable
fun ListasScreen() {
    val verdeOscuro = Color(0xFF2E7D6D)
    val grisClaro = Color(0xFFF5F5F5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grisClaro)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        // Título y subtítulo centrados
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Listas",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = verdeOscuro
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Observa tus listas creadas",
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Imagen decorativa (centrada, con márgenes)
        Image(
            painter = painterResource(id = R.drawable.listas), // Asegúrate de tener esta imagen en drawable
            contentDescription = "Imagen decorativa",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Lista de tarjetas
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            repeat(4) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    ListItem(
                        headlineContent = { Text("Lista", fontWeight = FontWeight.Bold) },
                        supportingContent = { Text("Descripción") },
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Default.List,
                                contentDescription = null,
                                tint = verdeOscuro
                            )
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListasScreenPreview() {
        ListasScreen()
}
