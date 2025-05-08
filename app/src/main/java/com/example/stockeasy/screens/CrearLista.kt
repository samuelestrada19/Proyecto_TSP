package com.example.stockeasy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockeasy.viewmodel.StockEasyViewModel

@Composable
fun CrearListaScreen(
    viewModel: StockEasyViewModel,
    onListaCreada: () -> Unit = {}
) {
    val fondo = Color(0xFF5E9CA0)
    val botonColor = Color(0xFF6DC2A6)
    val campoBlanco = Color.White

    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            // Botón cerrar personalizado
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color.White, shape = RoundedCornerShape(50))
                        .clickable { /* Acción cerrar */ },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "✕",
                        fontSize = 20.sp,
                        color = fondo,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Crea nueva lista",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Campo Nombre
            Text("Nombre", color = Color.White, modifier = Modifier.align(Alignment.Start), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                placeholder = { Text("Ingresa nombre") },
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = campoBlanco,
                    focusedContainerColor = campoBlanco
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Imagen simulada
            Text("Imagen", color = Color.White, modifier = Modifier.align(Alignment.Start), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .clickable { /* Acción seleccionar imagen */ },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Insertar foto", color = Color.DarkGray)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Descripción
            Text("Breve descripción", color = Color.White, modifier = Modifier.align(Alignment.Start), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                placeholder = { Text("Agrega una descripción") },
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = campoBlanco,
                    focusedContainerColor = campoBlanco
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (nombre.isNotBlank()) {
                        viewModel.agregarLista(nombre, descripcion)
                        onListaCreada()
                        nombre = ""
                        descripcion = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = botonColor),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("CREAR", fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun PreviewCrearListaScreen() {
    CrearListaScreen()
}*/
