package com.slyfly.nutrition.ui.theme.view.home

import ResultScannerViewModel
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.slyfly.nutrition.data.remote.DataItemBody
import com.slyfly.nutrition.ui.theme.view.View


@Composable
fun BodyView(modifier: Modifier=Modifier, navController: NavHostController,
             vm: ResultScannerViewModel) {
    //pour passer le context
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),modifier=modifier.fillMaxSize()
            .padding(20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement=Arrangement.spacedBy(20.dp)
    ) {items(
        DataItemBody(context).allItemBody()){itemBody->
        Surface {
            OutlinedCard(onClick ={ if(itemBody.name=="Scanner"){
            vm.scanAndFetchProduct(context){
                navController.navigate(View.ScannerResult.title)
            }}else{
                itemBody.onClick?.invoke()
            }
            } ,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                ),
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier
                    .size(width = 100.dp, height = 100.dp)
            ) {
                Column (modifier=Modifier.fillMaxSize()
                    .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ){

                    Image(painter = painterResource(id=itemBody.image), contentDescription = "",modifier=Modifier.height(60.dp).width(60.dp))
                    Text(
                        text = itemBody.name,

                        textAlign = TextAlign.Center,
                    )
                }

            }
        }

    }

    }

}


