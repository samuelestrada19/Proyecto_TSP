package com.example.stockeasy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockeasy.R
import com.example.stockeasy.viewmodel.StockEasyViewModel
import com.example.stockeasy.data.ListaEntity

@Composable
fun NombreListaScreen(
    lista: ListaEntity,
    viewModel: StockEasyViewModel,
    onEditarClick: () -> Unit = {},
    onSalirClick: () -> Unit = {}
) {
    val azulDetalle = Color(0xFF5D99A4)
    val productos = viewModel.productos

    LaunchedEffect(lista.id) {
        viewModel.cargarProductosDeLista(lista.id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(lista.nombre, fontSize = 28.sp, color = azulDetalle)
        Text(lista.descripcion, fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Artículos", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = azulDetalle)

        Spacer(modifier = Modifier.height(8.dp))

        productos.forEach { producto ->
            ListItem(
                headlineContent = { Text(producto.nombre) },
                supportingContent = {
                    Text("Descripción: ${producto.descripcion}\nCódigo: ${producto.codigo}\nExistencias: ${producto.existencias}")
                },
                leadingContent = {
                    Image(
                        painter = painterResource(id = R.drawable.producto),
                        contentDescription = "Producto",
                        modifier = Modifier.size(40.dp)
                    )
                },
                trailingContent = {
                    IconButton(onClick = { viewModel.eliminarProducto(producto) }) {
                        Icon(Icons.Default.Delete, contentDescription = "Eliminar", tint = Color.Red)
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = onSalirClick, colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)) {
                Text("SALIR", color = Color.Black)
            }

            Button(onClick = onEditarClick, colors = ButtonDefaults.buttonColors(containerColor = azulDetalle)) {
                Text("EDITAR", color = Color.White)
            }
        }
    }
}

/*@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NombreListaScreenPreview() {
    NombreListaScreen()
}*/
