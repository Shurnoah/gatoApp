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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
                    perfilGato()
                    perfilGato()
                }
            }
        }
    }
}

// List<Gato> lista;
// LazyColumn()
//



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun perfilGato() {
    Row(modifier = Modifier.fillMaxWidth().padding(6.dp).background(Color.LightGray)){
        Image(
            painter = painterResource(id = R.drawable.quicksilver),
            contentDescription = "GATOPERFIL",
            modifier = Modifier.size(80.dp)
            )
    // 1 - Crear data class Gato
        // 2 - laz

        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start) {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
                ){
                Text(text = "Gato")
                Text(text = "Nivel 28")
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround) {
                Text(text = "Tranquilo")
                Text(text = "Gris")
                Text(text = "Pelota")
            }
            Text(text = "12/12/12")
        }
    }

}