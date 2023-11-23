package com.example.gatoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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
                    println(lista[0].fecha)
                    LazyColumn(){
                        items(lista){gato ->
                            val nombre = gato.nombre
                            val imagen = gato.imagen
                            val nivel = gato.nivel
                            val personalidad = gato.personalidad
                            val color = gato.color
                            val juguete = gato.juguete
                            val fecha = gato.fecha
                            PerfilGato(nombre, imagen, nivel, personalidad, color, juguete, fecha)
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




@Composable
fun PerfilGato(nombre:String,
               imagen:Int,
               nivel:String,
               personalidad :String,
               color :String,
               juguete :String,
               fecha :Date) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(6.dp)
        .background(Color.LightGray)){
        Image(
            painter = painterResource(id = imagen),
            contentDescription = "GATOPERFIL",
            modifier = Modifier.size(80.dp)
            )
    // 1 - Crear data class Gato
        // Datepicker info:
        //https://semicolonspace.com/jetpack-compose-date-picker-material3/
        //formato fecha:
        //https://www.baeldung.com/java-simple-date-format


        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start) {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
                ){
                Text(text = nombre)
                Text(text = "Nivel: $nivel")
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround) {
                Text(text = "Personalidad: $personalidad")
                Text(text = "Pelaje: $color")
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround) {
                Text(text = "Juguete: $juguete")
                Text(text = "Fecha: $fecha")
            }
        }
    }
}