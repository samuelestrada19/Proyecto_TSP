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
import androidx.compose.foundation.clickable
import androidx.navigation.NavController
import com.example.stockeasy.R

@Composable
fun PantallaPrincipal(navController: NavController) {  // Cambié el nombre aquí
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 48.dp) // Ajustado para dejar espacio arriba
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lista),
                    contentDescription = "Agregar",
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = "Artículos",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                // Botón para navegar a la pantalla de agregar producto
                Image(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = "Agregar producto",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            navController.navigate("productoNuevo")  // Navegar a la pantalla de agregar producto
                        }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Buscar código o descripción") },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Buscar",
                        modifier = Modifier.size(20.dp)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                // Espacio vacío hasta que el usuario agregue productos
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.White)
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.price),
                    contentDescription = "Articulos",
                    modifier = Modifier.size(24.dp)
                )
                Text("Articulos", fontSize = 12.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.shopping_cart),
                    contentDescription = "Ventas",
                    modifier = Modifier.size(24.dp)
                )
                Text("Ventas", fontSize = 12.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.profit),
                    contentDescription = "Informes",
                    modifier = Modifier.size(24.dp)
                )
                Text("Informes", fontSize = 12.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.list),
                    contentDescription = "Menú",
                    modifier = Modifier.size(24.dp)
                )
                Text("Menú", fontSize = 12.sp)
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PantallaPrincipalPreview() {
    // PantallaPrincipal() ahora requiere NavController
//}
