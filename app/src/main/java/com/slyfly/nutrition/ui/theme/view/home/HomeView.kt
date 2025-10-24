package com.slyfly.nutrition.ui.theme.view.home

import ResultScannerViewModel
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState


import androidx.navigation.compose.rememberNavController
import com.slyfly.nutrition.ui.theme.view.View
import com.slyfly.nutrition.ui.theme.view.scanner.ScannerResultView


@Composable
fun HomeView() {
    val navigationController = rememberNavController()

    // On crée le ViewModel une seule fois ici et on le partage aux écrans
    val scannerVm: ResultScannerViewModel = viewModel()

    Scaffold(
        topBar = { AppBarView() },
    ) { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = View.HomeView.title,
            modifier = Modifier.padding(paddingValues)
        ) {
            // Écran d'accueil (la grille avec Scanner / Liste Produit / etc.)
            composable(View.HomeView.title) {
                BodyView(
                    navController = navigationController,
                    vm = scannerVm
                )
            }

            // Écran du résultat du scan
            composable(View.ScannerResult.title) {
                ScannerResultView(
                    vm = scannerVm
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeView()
}