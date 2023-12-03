package com.example.gatoapp.DatosAlmacenados.Formulario

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gatoapp.DatosAlmacenados.Detalle
import com.example.gatoapp.DatosAlmacenados.DetallesGatoArray
import com.example.gatoapp.DatosAlmacenados.Gato
import com.example.gatoapp.DatosAlmacenados.detalle
import com.example.gatoapp.DatosAlmacenados.lista
import com.example.gatoapp.modelo.Rutas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun formulario(){
    val nombre = detalle.map { it.nombre }
    val foto = detalle.map { it.imagen }
    var menuAbierto by remember {mutableStateOf(false)}
    var manzana by remember {mutableStateOf (nombre[0])}
    var juguete by remember {mutableStateOf ("")}
    var valorSlider by remember { mutableFloatStateOf(0f) }
    var fecha by remember {mutableStateOf ("")}

Column (Modifier.fillMaxSize()){
    Text(
        modifier = Modifier
        .fillMaxSize().weight(0.5f)
        .padding(4.dp),
        text = "Introduce los datos del gato con el que te encontraste:")

    Row(
        modifier = Modifier
            .height(120.dp)
            .fillMaxSize().weight(1f)
            .padding(6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Image(painter = painterResource(id = foto[nombre.indexOf(manzana)]),
            contentDescription = "GATOPERFIL",
            modifier = Modifier.size(80.dp))

        ExposedDropdownMenuBox(
            expanded = menuAbierto
            , onExpandedChange = { menuAbierto = !menuAbierto} ) {
            TextField(value = manzana,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .fillMaxSize().weight(1f)
                    .menuAnchor()
            )
            DropdownMenu(expanded = menuAbierto   , onDismissRequest = { menuAbierto = false}) {
                nombre.forEach {elemento ->
                    DropdownMenuItem(
                        text = { Text(text = elemento) },
                        onClick = { manzana = elemento;menuAbierto = false}) }
            }
        }
    }

    Text(modifier = Modifier
        .fillMaxSize().weight(0.5f)
        .padding(4.dp),
        text = "Color del Gatito",
        fontSize = 20.sp
    )
    Text(modifier = Modifier
        .fillMaxSize().weight(0.5f)
        .padding(4.dp),
        text = lista[nombre.indexOf(manzana)].color,
        fontSize = 20.sp
    )

    Text(modifier = Modifier
        .fillMaxSize().weight(0.5f)
        .padding(4.dp),
        text = "Personalidad del Gatito",
        fontSize = 20.sp
    )
    Text(modifier = Modifier
        .fillMaxSize().weight(0.5f)
        .padding(4.dp),
        text = lista[nombre.indexOf(manzana)].personalidad,
        fontSize = 20.sp
    )

    TextField(
        value = juguete, 
        onValueChange = {juguete=it},
        modifier = Modifier.fillMaxSize().weight(1f),
        placeholder = { Text(text = "Juguete del gato:")}
    )

    Text(text = "Nivel del gato:")
    Slider(
        value = valorSlider,
        onValueChange = { valorSlider = it},
        modifier = Modifier.weight(1f)
    )

    TextField(
        value = fecha,
        onValueChange = {fecha=it},
        modifier = Modifier.fillMaxSize().weight(1f),
        placeholder = { Text(text = "Fecha de encuentro con el gato:")}
    )

    TextButton(
        modifier = Modifier
            .weight(1f)
            .padding(2.dp)
            .fillMaxSize(),
        onClick = {
            lista.add(
                Gato(
                    lista[nombre.indexOf(manzana)].nombre,
                    lista[nombre.indexOf(manzana)].imagen,
                    valorSlider.toString(),
                    lista[nombre.indexOf(manzana)].personalidad,
                    lista[nombre.indexOf(manzana)].color,
                    juguete,
                    fecha,

                )
            )
        }

    ) {
        Text(
            text = "Agregar Gatito",
            fontSize = 20.sp
        )
    }
}
}
//val nombre = gato.nombre
//val imagen = gato.imagen
//val nivel = gato.nivel
//val personalidad = gato.personalidad
//val color = gato.color
//val juguete = gato.juguete
//val fecha = gato.fecha