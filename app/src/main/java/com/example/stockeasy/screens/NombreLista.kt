package com.example.stockeasy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockeasy.R


@Composable
fun NombreListaScreen() {
    // Funciones de los botones
    val onSalirClick = {
        // Acción al hacer clic en "SALIR"
        println("Botón SALIR presionado")
        // Aquí puedes navegar a otra pantalla o hacer alguna acción.
    }

    val onEditarClick = {
        // Acción al hacer clic en "EDITAR"
        println("Botón EDITAR presionado")
        // Aquí puedes abrir un formulario de edición o cualquier otra acción.
    }

    val azulDetalle = Color(0xFF5D99A4)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Títulos centrados en la parte superior
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally // Centramos horizontalmente
        ) {
            Text(
                text = "Nombre de la lista",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = azulDetalle // Aplicamos el color solicitado
            )

            Text(
                text = "Descripción de la lista",
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp) // Un pequeño espacio adicional
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Espacio con fondo verde y la imagen pequeña en su interior
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp) // Tamaño del espacio verde
                .background(azulDetalle) // Fondo verde
                .padding(16.dp), // Espacio para la imagen y la leyenda
            contentAlignment = Alignment.Center // Centrado de la imagen pequeña dentro del recuadro
        ) {
            // Imagen pequeña dentro del recuadro verde
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.foto), // Aquí va la imagen pequeña que el usuario puede poner
                    contentDescription = "Foto almacén",
                    modifier = Modifier
                        .size(60.dp) // Tamaño de la imagen pequeña
                        .background(azulDetalle) // El fondo verde en lugar de blanco
                        .padding(8.dp),
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Foto de la lista",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black // El color de la leyenda será blanco para que resalte
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Artículos",
            fontWeight = FontWeight.Bold,
            color = azulDetalle // Aplicamos el color solicitado
        )

        repeat(3) {
            ListItem(
                headlineContent = { Text("Artículo") },
                supportingContent = { Text("Descripción") },
                leadingContent = {
                    Image(
                        painter = painterResource(id = R.drawable.producto), // Aquí la imagen de "producto"
                        contentDescription = "Producto",
                        modifier = Modifier.size(40.dp) // Ajustamos el tamaño de la imagen
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Botón SALIR
            Button(onClick = onSalirClick, colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)) {
                Text("SALIR", color = Color.Black)
            }

            // Botón EDITAR
            Button(onClick = onEditarClick, colors = ButtonDefaults.buttonColors(containerColor = azulDetalle)) {
                Text("EDITAR", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NombreListaScreenPreview() {
    NombreListaScreen()
}


