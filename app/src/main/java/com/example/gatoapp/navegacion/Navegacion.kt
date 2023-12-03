package com.example.gatoapp.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gatoapp.BarraBusqueda
import com.example.gatoapp.DatosAlmacenados.Formulario.formulario
import com.example.gatoapp.PantallaPrincipal.PantallaMenu
import com.example.gatoapp.detalleGato
import com.example.gatoapp.modelo.Rutas
import com.example.gatoapp.pantallaborrado

@Composable
fun GrafoNavegacion() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.MainMenu.ruta) {

        composable("inicio") {
            PantallaMenu(navController = navController)
        }

        composable("busqueda") {
            BarraBusqueda(navController = navController)
        }

        composable(
            route = "detalle/{nombre}", arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
            )
        ) { backstackEntry ->
            detalleGato(nombre = backstackEntry.arguments?.getString("nombre"))
        }

        composable("agregar") {
            formulario()
        }
        composable("borrar") {
            pantallaborrado()
        }

    }

}