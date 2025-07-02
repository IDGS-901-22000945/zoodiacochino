package com.example.examenparcial2.iu

import android.media.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.examenparcial2.data.HoroscopeUtil
import com.example.examenparcial2.data.UserData
import androidx.compose.foundation.Image


@Composable
fun HoroscopeScreen(user: UserData) {
    val edad = HoroscopeUtil
        .calcularEdad(user.dia, user.mes, user.anio)
    val signo = HoroscopeUtil.obtenerSignoChino(user.anio)
    val imagenId = HoroscopeUtil.getImageResourceForSign(signo.lowercase())


    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Hola ${user.nombre} ${user.apellidoPaterno} ${user.apellidoMaterno}")
        Text("Tienes $edad años")
        Text("Tu signo zodiacal chino es $signo")
        Image(
            painter = painterResource(id = imagenId),
            contentDescription = signo,
            modifier = Modifier.size(180.dp)
        )
    }
}
