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
import com.slyfly.nutrition.ui.theme.view.customerproductlist.CustomerProductListView
import com.slyfly.nutrition.ui.theme.view.customerproductlist.productvariety.CustomerProductListProductVarietyView
import com.slyfly.nutrition.ui.theme.view.customerproductlist.productvariety.detailproduct.CustomerProductListProductVarietyDetailProductView
import com.slyfly.nutrition.ui.theme.view.scanner.ScannerResultView
import com.slyfly.nutrition.viewmodel.CustomerProductListViewModel


@Composable
fun HomeView() {
    val navigationController = rememberNavController()


    val scannerVm: ResultScannerViewModel = viewModel()
    val customerProductList : CustomerProductListViewModel=viewModel()


    Scaffold(
        topBar = { AppBarView(
            navController = navigationController
        ) },
    ) { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = View.HomeView.title,
            modifier = Modifier.padding(paddingValues)
        ) {
            // Ecran d'accueil
            composable(View.HomeView.title) {
                BodyView(
                    navController = navigationController,
                    vm = scannerVm
                )
            }

            // Ecran résultat du scan
            composable(View.ScannerResult.title) {
                ScannerResultView(
                    vm = scannerVm
                )
            }
            //Ecran liste produit
            composable(View.CustomerProductList.title) {
                // On crée le ViewModel


                // On affiche la vue et on lui passe le ViewModel
                CustomerProductListView(
                    modifier = Modifier,
                    vm = customerProductList,
                    navController = navigationController
                )
            }
            composable (View.CustomerProductListProductVariety.title){
                CustomerProductListProductVarietyView(

                    navController = navigationController,
                    vm=customerProductList
                )
            }
            composable (View.CustomerProductListProductVarietyDetail.title){
                CustomerProductListProductVarietyDetailProductView(
                    navController=navigationController,
                    vm=customerProductList
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