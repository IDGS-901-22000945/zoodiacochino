package com.example.examenparcial2.iu

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.examenparcial2.data.Question

@Composable
fun QuizScreen(questions: List<Question>, onFinish: (Int) -> Unit) {
    val selectedAnswers = remember { mutableStateListOf<Int?>(null, null, null, null, null, null) }

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        itemsIndexed(questions) { index, question ->
            Text(text = "${index + 1}. ${question.question}", fontWeight = FontWeight.Bold)
            question.options.forEachIndexed { optIndex, option ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedAnswers[index] == optIndex,
                        onClick = { selectedAnswers[index] = optIndex }
                    )
                    Text(option)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Button(
                onClick = {
                    val score = questions.indices.count { i ->
                        selectedAnswers[i] == questions[i].correctAnswerIndex
                    }
                    onFinish(score)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Terminar")
            }
        }
    }
}
