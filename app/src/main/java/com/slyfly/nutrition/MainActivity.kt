package com.slyfly.nutrition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.slyfly.nutrition.ui.theme.NutritionTheme
import com.slyfly.nutrition.ui.theme.view.View
import com.slyfly.nutrition.ui.theme.view.home.HomeView
import com.slyfly.nutrition.ui.theme.view.users.signupsignin.SignInView
import com.slyfly.nutrition.ui.theme.view.users.signupsignin.SignUpView


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            NutritionTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = View.SignUpView.title
                ) {
                    composable(View.SignUpView.title) {
                        SignUpView(navController = navController)
                    }
                    composable(View.SignInView.title) {
                        SignInView(navController = navController)
                    }

                    composable("home") {
                        HomeView()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NutritionTheme {
        Greeting("Android")
    }
}