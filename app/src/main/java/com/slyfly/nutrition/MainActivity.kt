package com.slyfly.nutrition

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.slyfly.nutrition.data.remote.ApiFindProduct
import com.slyfly.nutrition.model.barcode.BarCodeScanner
import com.slyfly.nutrition.ui.theme.NutritionTheme


class MainActivity : ComponentActivity() {
    private val TAG:String="CHECK_RESPONSE_2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // val barCodeScanner=BarCodeScanner(this)
       // barCodeScanner.startScanner{result -> Log.i(TAG,result?:"Null")}

        val apiFindProduct=ApiFindProduct(this)
        apiFindProduct.loadProduct()
        enableEdgeToEdge()
        setContent {
            NutritionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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