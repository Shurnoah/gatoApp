package com.example.gatoapp.DatosAlmacenados

data class Gato(
        var nombre:String,
        var imagen:Int,
        var nivel:String,
        var personalidad:String,
        var color:String,
        var juguete:String,
        var fecha: String
    ) {
    fun doesMatchSearchQuery(query: String):Boolean{
        val matchingCombinations = listOf( //distintos filtros de busqueda
            nombre,
            personalidad,
            color,
            "$color $color",
            "$color y $color",
            juguete,
            fecha
        )
        return matchingCombinations.any {
            it.contains(query,ignoreCase = true) //aceptar cuando coincide a medias
        }
    }
}