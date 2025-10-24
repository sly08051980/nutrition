package com.slyfly.nutrition.ui.theme.view.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview



@Composable
fun HomeView() {
    Scaffold(
        topBar = { AppBarView() },
        content = { paddingValues ->
            BodyView(
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeView()
}