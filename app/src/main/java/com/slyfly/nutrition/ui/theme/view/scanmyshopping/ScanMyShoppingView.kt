package com.slyfly.nutrition.ui.theme.view.scanmyshopping

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable

fun ScanMyShoppingView(modifier: Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),modifier=modifier.fillMaxSize()
            .padding(20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement= Arrangement.spacedBy(20.dp)
    ) { }

}
@Preview(showBackground = true)
@Composable
fun ScanMyshoppingViewGretting(){
    ScanMyShoppingView(modifier = Modifier)
}