package com.example.stockeasy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.KeyboardType
import com.example.stockeasy.R
import com.example.stockeasy.viewmodel.StockEasyViewModel
import com.example.stockeasy.data.ListaEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductoNuevo(
    viewModel: StockEasyViewModel,
    onProductoGuardado: () -> Unit = {}
) {
    val azulDetalle = Color(0xFF5D99A4)

    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var codigo by remember { mutableStateOf("") }
    var existencias by remember { mutableStateOf("") }

    val listas = viewModel.listas
    var listaSeleccionada by remember { mutableStateOf<ListaEntity?>(null) }
    var listaExpandida by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        if (listas.isEmpty()) viewModel.cargarListas()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
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
                onClick = {
                    listaSeleccionada?.let {
                        val exist = existencias.toIntOrNull() ?: 0
                        viewModel.agregarProducto(
                            nombre,
                            descripcion,
                            codigo,
                            exist,
                            it.id
                        )
                        onProductoGuardado()
                        nombre = ""
                        descripcion = ""
                        codigo = ""
                        existencias = ""
                        listaSeleccionada = null
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = azulDetalle)
            ) {
                Text("Guardar", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // DropdownMenu para seleccionar lista
        ExposedDropdownMenuBox(
            expanded = listaExpandida,
            onExpandedChange = { listaExpandida = !listaExpandida }
        ) {
            OutlinedTextField(
                value = listaSeleccionada?.nombre ?: "",
                onValueChange = {},
                readOnly = true,
                label = { Text("Lista") },
                trailingIcon = {
                    Icon(Icons.Filled.ArrowDropDown, contentDescription = "Expandir")
                },
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = listaExpandida,
                onDismissRequest = { listaExpandida = false }
            ) {
                listas.forEach { lista ->
                    DropdownMenuItem(
                        text = { Text(lista.nombre) },
                        onClick = {
                            listaSeleccionada = lista
                            listaExpandida = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = codigo,
            onValueChange = { codigo = it },
            label = { Text("Código") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = existencias,
            onValueChange = { existencias = it },
            label = { Text("Existencias") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun ProductoNuevoPreview() {
//    ProductoNuevo()
//}

