package com.slyfly.nutrition.ui.theme.view.customerproductlist

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.slyfly.nutrition.function.Function
import com.slyfly.nutrition.ui.theme.view.View
import com.slyfly.nutrition.viewmodel.CustomerProductListViewModel

@Composable
fun CustomerProductListView(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    vm: CustomerProductListViewModel = viewModel()
) {
    val TAG12="TEST_RESPONSE"
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        vm.customerProductList(context) {}
    }

    val items by vm.items.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .fillMaxSize()
            .background(Function().functionGradientBlueToWhite())
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items) { item ->

            Card(
                onClick = {
                    vm.selectCategory(item.name)
                    navController.navigate(View.CustomerProductListProductVariety.title)
                },
                elevation = CardDefaults.cardElevation(4.dp),
                modifier = Modifier.padding(4.dp)
            ) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = item.name,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = item.name,
                    modifier = Modifier.padding(8.dp)
                )

            }

        }
    }
}
