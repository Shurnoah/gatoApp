package com.example.gatoapp.modelo

sealed class Rutas(val ruta: String){
    object MainMenu : Rutas("inicio")
    object BarraBusqueda : Rutas("busqueda")

    //object DetalleGato : Rutas("detalle/{nombre}")
    object agregar: Rutas("agregar")
    object borrar: Rutas("borrar")
}