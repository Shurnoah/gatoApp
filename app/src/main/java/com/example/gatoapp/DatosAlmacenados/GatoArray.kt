package com.example.gatoapp.DatosAlmacenados

import java.util.Date

data class Gato (
        var nombre :String,
        var imagen:Int,
        var nivel:String,
        var personalidad :String,
        var color :String,
        var juguete :String,
        var fecha :Date
    )
