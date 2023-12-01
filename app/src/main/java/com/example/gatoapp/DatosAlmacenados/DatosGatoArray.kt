package com.example.gatoapp.DatosAlmacenados

import com.example.gatoapp.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


// var1 = DatosGatOArray()
// var2 = DatosGatoArray()

// var1.rellenarLista()
// var2.lista[0]

val lista = ArrayList<Gato>()
class DatosGatoArray {

    fun rellenarlista(){
        val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.ROOT)
        lista.add(
                Gato("Fred",
                R.drawable.fred,
                "",
                "Juguetón",
                "Naranja Atigrado",
                "",
                    formatter.format(Date())
            )
        )
        lista.add(
            Gato("Gozer",
                R.drawable.gozer,
                "",
                "Cazador",
                "Manchitas Atigrado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Ari",
                R.drawable.hermeowne,
                "",
                "Astuta",
                "Negro",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Peaches",
                R.drawable.peaches,
                "",
                "Juguetona",
                "Naranja Tostado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Pimienta",
                R.drawable.pepper,
                "",
                "Tímido",
                "Negro",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Pickles",
                R.drawable.pickles,
                "",
                "Astuto",
                "Gris Atigrado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Quicksilver",
                R.drawable.quicksilver,
                "",
                "Tranquilo",
                "Gris",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Sapphire",
                R.drawable.sapphire,
                "",
                "Tímida",
                "Gris",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Vaquita",
                R.drawable.sooty,
                "",
                "Cazadora",
                "Blanco",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Fred",
                R.drawable.fred,
                "",
                "Juguetón",
                "Naranja Atigrado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Gozer",
                R.drawable.gozer,
                "",
                "Cazador",
                "Manchitas Atigrado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Ari",
                R.drawable.hermeowne,
                "",
                "Astuta",
                "Negro",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Peaches",
                R.drawable.peaches,
                "",
                "Juguetona",
                "Naranja Tostado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Pimienta",
                R.drawable.pepper,
                "",
                "Tímido",
                "Negro",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Pickles",
                R.drawable.pickles,
                "",
                "Astuto",
                "Gris Atigrado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Quicksilver",
                R.drawable.quicksilver,
                "",
                "Tranquilo",
                "Gris",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Sapphire",
                R.drawable.sapphire,
                "",
                "Tímida",
                "Gris",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Vaquita",
                R.drawable.sooty,
                "",
                "Cazadora",
                "Blanco",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Fred",
                R.drawable.fred,
                "",
                "Juguetón",
                "Naranja Atigrado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Gozer",
                R.drawable.gozer,
                "",
                "Cazador",
                "Manchitas Atigrado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Ari",
                R.drawable.hermeowne,
                "",
                "Astuta",
                "Negro",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Peaches",
                R.drawable.peaches,
                "",
                "Juguetona",
                "Naranja Tostado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Pimienta",
                R.drawable.pepper,
                "",
                "Tímido",
                "Negro",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Pickles",
                R.drawable.pickles,
                "",
                "Astuto",
                "Gris Atigrado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Quicksilver",
                R.drawable.quicksilver,
                "",
                "Tranquilo",
                "Gris",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Sapphire",
                R.drawable.sapphire,
                "",
                "Tímida",
                "Gris",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Vaquita",
                R.drawable.sooty,
                "",
                "Cazadora",
                "Blanco",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Fred",
                R.drawable.fred,
                "",
                "Juguetón",
                "Naranja Atigrado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Gozer",
                R.drawable.gozer,
                "",
                "Cazador",
                "Manchitas Atigrado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Ari",
                R.drawable.hermeowne,
                "",
                "Astuta",
                "Negro",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Peaches",
                R.drawable.peaches,
                "",
                "Juguetona",
                "Naranja Tostado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Pimienta",
                R.drawable.pepper,
                "",
                "Tímido",
                "Negro",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Pickles",
                R.drawable.pickles,
                "",
                "Astuto",
                "Gris Atigrado",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Quicksilver",
                R.drawable.quicksilver,
                "",
                "Tranquilo",
                "Gris",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Sapphire",
                R.drawable.sapphire,
                "",
                "Tímida",
                "Gris",
                "",
                formatter.format(Date())
            )
        )
        lista.add(
            Gato("Vaquita",
                R.drawable.sooty,
                "",
                "Cazadora",
                "Blanco",
                "",
                formatter.format(Date())
            )
        )
    }

//    var nombre :String,
//    var imagen:Int,
//    var nivel:String,
//    var personalidad :String,
//    var color :String,
//    var juguete :String,
//    var fecha :  String
}