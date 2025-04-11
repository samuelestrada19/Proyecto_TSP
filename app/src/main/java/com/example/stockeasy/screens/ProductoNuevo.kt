package com.example.stockeasy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun ProductoNuevo() {
    val azulDetalle = Color(0xFF5D99A4)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Fila superior con título y botón guardar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Producto",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = azulDetalle
            )

            Button(
                onClick = { /* Guardar */ },
                colors = ButtonDefaults.buttonColors(containerColor = azulDetalle)
            ) {
                Text("Guardar", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Imagen de producto (placeholder)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(azulDetalle, RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.foto),
                    contentDescription = "Sin imagen",
                    modifier = Modifier
                        .size(80.dp)
                        .padding(8.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { /* Insertar imagen */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier.height(40.dp)
                ) {
                    Text("Agregar imagen", fontSize = 12.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Detalle", color = Color.Gray, fontSize = 14.sp)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Código") },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(
                    onClick = { /* Acción del botón */ },
                    modifier = Modifier
                        .height(28.dp)
                        .width(36.dp)
                        .background(Color.Transparent) // Botón plano
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.codigo),
                        contentDescription = "Escanear código",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Existencias") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProductoNuevoPreview() {
    ProductoNuevo()
}
