package com.example.examenparcial2.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.examenparcial2.data.HoroscopeUtil
import com.example.examenparcial2.data.UserData

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ResultScreen(user: UserData, score: Int, onBack: () -> Unit) {
    val edad = HoroscopeUtil.calcularEdad(user.dia, user.mes, user.anio)
    val signo = HoroscopeUtil.obtenerSignoChino(user.anio)
    val imagenId = HoroscopeUtil.getImageResourceForSign(signo.lowercase())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "🌟 ¡Hola ${user.nombre} ${user.apellidoPaterno} ${user.apellidoMaterno}! 🌟",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "🎂 Tienes $edad años",
            style = MaterialTheme.typography.labelLarge
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "🐲 Tu signo chino es: $signo",
            style = MaterialTheme.typography.labelLarge
        )
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = imagenId),
            contentDescription = "Signo $signo",
            modifier = Modifier
                .size(200.dp)
                .padding(12.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "📚 Calificación: $score / 6",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onBack() },
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(48.dp)
        ) {
            Text("🔙 Volver al formulario")
        }
    }
}
