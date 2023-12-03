package com.example.gatoapp.PantallaPrincipal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gatoapp.BarraBusqueda
import com.example.gatoapp.DatosAlmacenados.lista
import com.example.gatoapp.PerfilGato
import com.example.gatoapp.modelo.Rutas

@Composable
fun PantallaMenu(navController: NavController) {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Buscador de Gatos",
            modifier = Modifier
                .weight(1f)
                .padding(2.dp)
                .fillMaxSize(),
            fontSize = 20.sp)
        TextButton(
            modifier = Modifier
                .weight(1f)
                .padding(2.dp)
                .fillMaxSize(),
            onClick = {
                navController.navigate(Rutas.BarraBusqueda.ruta)
            }

        ) {
            Text(
                text = "Busqueda",
                fontSize = 20.sp
            )
        }
        LazyColumn(
            modifier = Modifier
                .weight(8f)
                .fillMaxSize()
        ) {
            items(lista) { gato ->
                val nombre = gato.nombre
                val imagen = gato.imagen
                val nivel = gato.nivel
                val personalidad = gato.personalidad
                val color = gato.color
                val juguete = gato.juguete
                val fecha = gato.fecha
                PerfilGato(
                    nombre,
                    imagen,
                    nivel,
                    personalidad,
                    color,
                    juguete,
                    fecha,
                    navController
                )
            }
        }
        TextButton(
            modifier = Modifier
                .weight(1f)
                .padding(2.dp)
                .fillMaxSize(),
            onClick = {
            }

        ) {
            Row {
                TextButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(2.dp)
                        .fillMaxSize(),
                    onClick = {
                        navController.navigate(Rutas.agregar.ruta)
                    }

                ) {
                    Text(
                        text = "Agregar Gatito",
                        fontSize = 20.sp
                    )
                }
                TextButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(2.dp)
                        .fillMaxSize(),
                    onClick = {
                        navController.navigate(Rutas.borrar.ruta)
                    }

                ) {
                    Text(
                        text = "Borrar Gatito",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}