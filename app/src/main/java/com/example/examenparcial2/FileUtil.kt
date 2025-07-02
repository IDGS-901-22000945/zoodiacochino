package com.example.examenparcial2.data

import android.content.Context
import java.io.File
import java.io.FileOutputStream

object FileUtil {
    fun guardarResultado(context: Context, user: UserData, score: Int) {
        val fileName = "resultado_${user.nombre}_${user.apellidoPaterno}.txt"
        val contenido = """
            Nombre: ${user.nombre} ${user.apellidoPaterno} ${user.apellidoMaterno}
            Fecha de nacimiento: ${user.dia}/${user.mes}/${user.anio}
            Sexo: ${user.sexo}
            Calificación: $score / 6
        """.trimIndent()

        try {
            val file = File(context.filesDir, fileName)
            FileOutputStream(file).use {
                it.write(contenido.toByteArray())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
