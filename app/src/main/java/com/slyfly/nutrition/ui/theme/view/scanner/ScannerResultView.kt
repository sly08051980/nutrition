package com.slyfly.nutrition.ui.theme.view.scanner

import ResultScannerViewModel
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable

fun ScannerResultView(vm:ResultScannerViewModel= viewModel()){

    val product by vm.product.collectAsState()
    Row {
        Text(text = "nom: ${product?.product_name}")
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewScaner(){
    ScannerResultView()
}