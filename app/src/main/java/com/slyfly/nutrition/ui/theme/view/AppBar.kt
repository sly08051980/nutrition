package com.slyfly.nutrition.ui.theme.view





import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth


import androidx.compose.material3.CenterAlignedTopAppBar

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview


import com.slyfly.nutrition.ui.theme.EndBlue
import com.slyfly.nutrition.ui.theme.MiddleBlue

import com.slyfly.nutrition.ui.theme.StartBlue

val gradient= Brush.verticalGradient(
                   listOf(StartBlue, MiddleBlue, EndBlue),
                   startY = 0.0f,
                   endY = 300.0f
              )


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun AppBar() {
    Box{
        CenterAlignedTopAppBar(

            title = { Text(text = "Nutrition",
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
                 
                )
            }     ,
                modifier = Modifier.background(gradient),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            )
        )       





    }








}
@Composable
fun ScaffoldComposable(){
    Scaffold(
        topBar = { AppBar() },
        content = {}
    )
}
@Preview(showBackground = true)
@Composable
fun gretPrewiev(){
   ScaffoldComposable()
}