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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CrearListaScreen() {
    val fondo = Color(0xFF5E9CA0)       // fondo azul verdoso
    val botonColor = Color(0xFF6DC2A6)  // botón verde menta
    val campoBlanco = Color.White

    var nombre by remember { mutableStateOf(TextFieldValue("")) }
    var descripcion by remember { mutableStateOf(TextFieldValue("")) }
    var lista by remember { mutableStateOf(TextFieldValue("")) }

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

            // Contenedor para centrar el texto completamente
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Crea nueva\nlista",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Nombre
            Text("Nombre", color = Color.White, modifier = Modifier.align(Alignment.Start),
                fontWeight = FontWeight.Bold)
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

            // Imagen
            Text("Imagen", color = Color.White, modifier = Modifier.align(Alignment.Start),
                fontWeight = FontWeight.Bold)
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
            Text("Breve descripción", color = Color.White, modifier = Modifier.align(Alignment.Start),
                fontWeight = FontWeight.Bold)
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

            Spacer(modifier = Modifier.height(16.dp))

            // Lista
            Text("Lista", color = Color.White, modifier = Modifier.align(Alignment.Start),
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                value = lista,
                onValueChange = { lista = it },
                placeholder = { Text("Agrega artículos a tu lista") },
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = campoBlanco,
                    focusedContainerColor = campoBlanco
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { /* Acción crear lista */ },
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

@Preview(showBackground = true)
@Composable
fun PreviewCrearListaScreen() {
    CrearListaScreen()
}
