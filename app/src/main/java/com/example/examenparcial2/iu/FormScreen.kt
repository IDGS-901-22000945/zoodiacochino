package com.example.examenparcial2.iu

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.examenparcial2.data.UserData

@Composable
fun FormScreen(onNext: (UserData) -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var apellidoPaterno by remember { mutableStateOf("") }
    var apellidoMaterno by remember { mutableStateOf("") }
    var dia by remember { mutableStateOf("") }
    var mes by remember { mutableStateOf("") }
    var anio by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("Masculino") }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Formulario de Registro", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = apellidoPaterno,
            onValueChange = { apellidoPaterno = it },
            label = { Text("Apellido Paterno") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = apellidoMaterno,
            onValueChange = { apellidoMaterno = it },
            label = { Text("Apellido Materno") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                value = dia,
                onValueChange = { dia = it },
                label = { Text("Día") },
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = mes,
                onValueChange = { mes = it },
                label = { Text("Mes") },
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = anio,
                onValueChange = { anio = it },
                label = { Text("Año") },
                modifier = Modifier.weight(1f)
            )
        }

        Text("Sexo", style = MaterialTheme.typography.titleMedium)

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            RadioButton(
                selected = sexo == "Masculino",
                onClick = { sexo = "Masculino" }
            )
            Text("Masculino")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(
                selected = sexo == "Femenino",
                onClick = { sexo = "Femenino" }
            )
            Text("Femenino")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedButton(onClick = {
                nombre = ""
                apellidoPaterno = ""
                apellidoMaterno = ""
                dia = ""
                mes = ""
                anio = ""
                sexo = "Masculino"
            }) {
                Text("Limpiar")
            }

            Button(onClick = {
                if (dia.isNotBlank() && mes.isNotBlank() && anio.isNotBlank()) {
                    onNext(
                        UserData(
                            nombre,
                            apellidoPaterno,
                            apellidoMaterno,
                            dia.toIntOrNull() ?: 1,
                            mes.toIntOrNull() ?: 1,
                            anio.toIntOrNull() ?: 2000,
                            sexo
                        )
                    )
                }
            }) {
                Text("Siguiente")
            }
        }
    }
}
