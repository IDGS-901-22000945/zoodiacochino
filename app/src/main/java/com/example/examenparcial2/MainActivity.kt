package com.example.examenparcial2

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.*
import com.example.examenparcial2.data.*
import com.example.examenparcial2.iu.FormScreen
import com.example.examenparcial2.iu.HoroscopeScreen
import com.example.examenparcial2.iu.QuizScreen
import com.example.examenparcial2.ui.ResultScreen
import com.example.examenparcial2.ui.theme.ExamenParcial2Theme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ExamenParcial2Theme {
                val navController = rememberNavController()

                var userData by remember { mutableStateOf<UserData?>(null) }
                var score by remember { mutableStateOf(0) }

                NavHost(navController = navController, startDestination = "form") {
                    composable("form") {
                        FormScreen { user ->
                            userData = user
                            navController.navigate("quiz")
                        }
                    }

                    composable("quiz") {
                        QuizScreen(
                            questions = questionList,
                            onFinish = { finalScore ->
                                score = finalScore
                                navController.navigate("result")
                            }
                        )
                    }

                    composable("result") {
                        userData?.let { user ->
                            val context = LocalContext.current

                            LaunchedEffect(Unit) {
                                FileUtil.guardarResultado(context, user, score)
                            }

                            ResultScreen(
                                user = user,
                                score = score,
                                onBack = {
                                    navController.navigate("form") {
                                        popUpTo("form") { inclusive = true }
                                    }
                                }
                            )
                        }
                    }

                    composable("horoscope") {
                        userData?.let { user ->
                            HoroscopeScreen(user)
                        }
                    }
                }
            }
        }
    }
}
