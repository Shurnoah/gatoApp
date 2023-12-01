@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.gatoapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.SearchBar
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gatoapp.BarraBusqueda.SearchViewModel
import com.example.gatoapp.DatosAlmacenados.DatosGatoArray
import com.example.gatoapp.DatosAlmacenados.Gato
import com.example.gatoapp.DatosAlmacenados.lista
import com.example.gatoapp.ui.theme.GatoAppTheme
import java.util.Date

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
                    Column(Modifier.fillMaxSize()) {

                        BarraBusqueda() //meter en un boton??
                        LazyColumn() {
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
                                    fecha
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// List<Gato> lista;
// LazyColumn()
//
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraBusqueda() {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var items = remember { mutableListOf(lista) }
    Scaffold {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
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
                val filtrado = lista.filter { gato -> gato.color.contains(text) }
                LazyColumn() {
                    items(filtrado) { Gato ->
                        Card {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(6.dp)
                                    .background(Color.LightGray)
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
                                        Text(text = "Nivel: ${Gato.nivel}")
                                    }
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceAround
                                    ) {
                                        Text(text = "Personalidad: ${Gato.personalidad}")
                                        Text(text = "Pelaje: ${Gato.color}")
                                    }
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceAround
                                    ) {
                                        Text(text = "Juguete: ${Gato.juguete}")
                                        Text(text = "Fecha: ${Gato.fecha}")
                                    }
                                }
                            }
                        }

                    }
                }
            } else {
                lista.forEach {
                        Gato ->
                    Row(modifier = Modifier.padding(all = 14.dp)) {
                        Icon(
                            modifier = Modifier.padding(end = 16.dp),
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "History Icon"
                        )
                        Text(text = "${Gato.color}")
                    }
                }
            }
        }

    }
}


@Composable
fun Buscador() {
    val viewModel = viewModel<SearchViewModel>()
    val searchText by viewModel.searchQuery.collectAsState()
    val gatos by viewModel.gatos.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        //esto es una animacion de carga, que realmente no sirve para nada
        if (isSearching) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(gatos) { gatos ->
                    Text(
                        text = gatos.color,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    )
                }
            }
        }
    }
}

// 1 - Crear data class Gato
// Datepicker info:
//https://semicolonspace.com/jetpack-compose-date-picker-material3/
//formato fecha:
//https://www.baeldung.com/java-simple-date-format
@Composable
fun PerfilGato(
    nombre: String,
    imagen: Int,
    nivel: String,
    personalidad: String,
    color: String,
    juguete: String,
    fecha: String
) {
    Card {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .background(Color.LightGray)
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