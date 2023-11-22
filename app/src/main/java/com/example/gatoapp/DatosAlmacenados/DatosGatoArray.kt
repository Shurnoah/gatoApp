package com.example.gatoapp.DatosAlmacenados

import com.example.gatoapp.R
import java.text.SimpleDateFormat
import java.util.Date


// var1 = DatosGatOArray()
// var2 = DatosGatoArray()

// var1.rellenarLista()
// var2.lista[0]

val lista = ArrayList<Gato>()
class DatosGatoArray {

    fun rellenarlista(){
        for(i in 0..100){
            lista.add(Gato("Quicksilver",
                R.drawable.quicksilver,
                "28",
                "Tranquil0",
                "Gris",
                "Esonja de maquillar",
                Date()
            ))
        }

    }

//    var nombre :String,
//    var imagen:Int,
//    var nivel:String,
//    var personalidad :String,
//    var color :String,
//    var juguete :String,
//    var fecha : Date
}