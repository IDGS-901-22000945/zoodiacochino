package com.example.examenparcial2.data

import com.example.examenparcial2.R
import java.time.LocalDate
import java.time.Period

object HoroscopeUtil {

    fun calcularEdad(dia: Int, mes: Int, anio: Int): Int {
        val birthDate = LocalDate.of(anio, mes, dia)
        return Period.between(birthDate, LocalDate.now()).years
    }

    fun obtenerSignoChino(anio: Int): String {
        val signos = listOf(
            "Rata", "Buey", "Tigre", "Conejo", "Dragón", "Serpiente",
            "Caballo", "Cabra", "Mono", "Gallo", "Perro", "Cerdo"
        )
        return signos[(anio - 4) % 12]
    }

    fun getImageResourceForSign(signo: String): Int {
        return when (signo.lowercase()) {
            "rata" -> R.drawable.rata
            "buey" -> R.drawable.buey
            "tigre" -> R.drawable.tigre
            "conejo" -> R.drawable.conejo
            "dragon", "dragón" -> R.drawable.dragon
            "serpiente" -> R.drawable.serpiente
            "caballo" -> R.drawable.caballo
            "cabra" -> R.drawable.cabra
            "mono" -> R.drawable.mono
            "gallo" -> R.drawable.gallo
            "perro" -> R.drawable.perro
            "cerdo" -> R.drawable.cerdo
            else -> R.drawable.signo_default
        }
    }
}
