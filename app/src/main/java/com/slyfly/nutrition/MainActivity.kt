package com.slyfly.nutrition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.slyfly.nutrition.ui.theme.NutritionTheme
import com.slyfly.nutrition.ui.theme.view.home.HomeView


class MainActivity : ComponentActivity() {
    private val TAG:String="CHECK_RESPONSE_2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    //    val apiFindProduct=ApiFindProduct(this)
      //  apiFindProduct.loadProduct()
        enableEdgeToEdge()
        setContent {
            NutritionTheme {
                HomeView()
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