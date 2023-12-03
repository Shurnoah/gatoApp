@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.gatoapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.SearchBar
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gatoapp.DatosAlmacenados.DatosGatoArray
import com.example.gatoapp.DatosAlmacenados.DetallesGatoArray
import com.example.gatoapp.DatosAlmacenados.detalle
import com.example.gatoapp.DatosAlmacenados.lista
import com.example.gatoapp.navegacion.GrafoNavegacion
import com.example.gatoapp.ui.theme.GatoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GatoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DatosGatoArray().rellenarlista()
                    DetallesGatoArray().rellenarDetalles()
                    GrafoNavegacion()
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraBusqueda(navController: NavController) {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    Scaffold {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth(),
            query = text,
            onQueryChange = { text = it },
            onSearch = { active = false },
            active = active,
            onActiveChange = { active = it },
            placeholder = { Text(text = "Busca por Pelajes") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            trailingIcon = {
                if (active) {
                    Icon(
                        modifier = Modifier.clickable {
                            text = ""
                            active = false
                        },
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon"
                    )
                }
            }

        ) {
            if (text.isNotEmpty()) {
                val filtrado = lista.filter { Gato -> Gato.color.contains(text) }
                LazyColumn() {
                    items(filtrado) { Gato ->
                        var gatonombre by remember { mutableStateOf("") }
                        Card {
                            Button(onClick = {
                                gatonombre = Gato.nombre
                                navController.navigate(route = "detalle/$gatonombre")
                            }) {
                                Row(
                                    modifier = Modifier
                                        .height(120.dp)
                                        .fillMaxWidth()
                                        .padding(6.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = Gato.imagen),
                                        contentDescription = "GATOPERFIL",
                                        modifier = Modifier.size(80.dp)
                                    )
                                    Column(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalAlignment = Alignment.Start
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(text = Gato.nombre)
                                            Text(text = " Nivel: ${Gato.nivel}")
                                        }
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceAround
                                        ) {
                                            Text(text = " Personalidad: ${Gato.personalidad}")
                                            Text(text = " Pelaje: ${Gato.color}")
                                        }
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceAround
                                        ) {
                                            Text(text = " Juguete: ${Gato.juguete}")
                                            Text(text = " Fecha: ${Gato.fecha}")
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            } else {
                lista.forEach { Gato ->
                    Row(modifier = Modifier.padding(all = 14.dp)) {
                        Icon(
                            modifier = Modifier.padding(end = 16.dp),
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "History Icon"
                        )
                        Text(text = Gato.color)
                    }
                }
            }
        }

    }
}


@Composable
fun PerfilGato(
    nombre: String,
    imagen: Int,
    nivel: String,
    personalidad: String,
    color: String,
    juguete: String,
    fecha: String,
    navController: NavController
) {
    var gatonombre by remember { mutableStateOf("") }
    Card {
        Button(onClick = {
            gatonombre = nombre
            navController.navigate(route = "detalle/$gatonombre")
        }) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                Image(
                    painter = painterResource(id = imagen),
                    contentDescription = "GATOPERFIL",
                    modifier = Modifier.size(80.dp)
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = nombre)
                        Text(text = "Nivel: $nivel")
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(text = "Personalidad: $personalidad")
                        Text(text = "Pelaje: $color")
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(text = "Juguete: $juguete")
                        Text(text = "Fecha: $fecha")
                    }
                }
            }
        }
    }
}

@Composable
fun DetalleGato(nombre: String?) {
    if (nombre.isNullOrEmpty()) {
        Text(text = "No hay gato para mostrar")
    } else {
        val detallegato = detalle.first() { Detalle -> Detalle.nombre.contains(nombre) }
        Column(modifier = Modifier
            .fillMaxSize().padding(2.dp)) {
            Text(text = detallegato.nombre,
                fontSize = 40.sp)
            Image(
                painter = painterResource(id = detallegato.imagen),
                contentDescription = "GATOPERFIL",
                modifier = Modifier.size(200.dp)
            )
            Text(text = detallegato.Texto)
        }

    }
}

    @Composable
    fun Pantallaborrado(){
        Column (modifier = Modifier
            .fillMaxSize(),
            Arrangement.Center,
            Alignment.CenterHorizontally){
            Text(text = "¯\\_ (ツ)_/¯",
                fontSize = 80.sp)
            Text(text = "sorry...",
                fontSize = 10.sp)
        }

    }


