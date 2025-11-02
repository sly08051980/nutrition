package com.slyfly.nutrition.ui.theme.view.customerproductlist.productvariety.detailproduct

import android.annotation.SuppressLint
import android.content.ClipData.Item
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.slyfly.nutrition.R
import com.slyfly.nutrition.viewmodel.CustomerProductListViewModel

@SuppressLint("RememberReturnType")
@Composable

fun CustomerProductListProductVarietyDetailProductView(
    modifier:Modifier=Modifier,
    navController:NavController,
    vm:CustomerProductListViewModel
){

    val context = LocalContext.current
    LaunchedEffect(Unit) {
        vm.customerProductList(context){}
    }

    val aliments= remember (vm.rawCategories.collectAsState().value,vm.choiceAliments,vm.choiceName){
        vm.buildAlimentsForSelectedAliment(context)
    }

val oligoElements = listOf(
    "Fer" to aliments?.fer,
    "Iode" to aliments?.iode,
    "Zinc" to aliments?.zinc,
    "Cuivre" to aliments?.cuivre,
    "Sélénium" to aliments?.selenium,
    "Manganèse" to aliments?.manganese

)
   val nutrimentRow =oligoElements.chunked(4)

    val macronutriments= listOf(
        "Lipides" to aliments?.lipides,
        "Protéines" to aliments?.proteines,
        "Fibres" to aliments?.fibres,
        "Sucres" to aliments?.sucres
    )

    val mineraux= listOf(
        "Calcium" to aliments?.calcium,
        "Sodium" to aliments?.sodium,
        "Magnésium" to aliments?.magnesium,
        "Phosphore" to aliments?.phosphore,
        "Potassium" to aliments?.potassium
    )
val minerauxRow= mineraux.chunked(4)

    val vitamine= listOf(
        "A" to aliments?.vitamine_a,
        "C" to aliments?.vitamine_c,
        "D" to aliments?.vitamine_d,
        "E" to aliments?.vitamine_e,
        "k" to aliments?.vitamine_k,
        "B1" to aliments?.vitamine_b1,
        "B2" to aliments?.vitamine_b2,
        "B3" to aliments?.vitamine_b3,
        "B5" to aliments?.vitamine_b5,
        "B6" to aliments?.vitamine_b6,
        "B7" to aliments?.vitamine_b7,
        "B9" to aliments?.vitamine_b9,
        "B12" to aliments?.vitamine_b12
    )

    val vitamineRow=vitamine.chunked(7)

    val macronutrimentsRow=macronutriments.chunked(4)
   Column (modifier=Modifier.fillMaxSize()
       .padding(12.dp)
       .verticalScroll(rememberScrollState())){

       if (aliments != null) {
          val image = remember(aliments.nom) {
              aliments.nom?: ""
          }
           val imageResId = remember(image) {
               val id = context.resources.getIdentifier(image,"drawable",context.packageName)
               if (id !=0) id else R.drawable.produitvegetal
           }
           Column(modifier=Modifier.fillMaxWidth()) { Image(painter = painterResource(imageResId), contentDescription = aliments.nom) }

           val replace = aliments.nom?.replace('_',' ')?.capitalize()
           Row (modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.Center){
               Text(text=replace?:"Produit non trouvé",textAlign = TextAlign.Center, fontSize = 50.sp, fontWeight = FontWeight.Bold)
           }


       }
       Column(modifier=Modifier.padding(0.dp,50.dp,0.dp,0.dp)
           ) { Text(text = "Nutriment",textAlign = TextAlign.Center, fontSize = 30.sp, fontWeight = FontWeight.Bold)
       nutrimentRow.forEach{
           nutrimentItem-> Row(modifier=Modifier.fillMaxWidth()) {
               nutrimentItem.forEach{(label,value)->
                   Column(modifier=Modifier.padding(12.dp)) {
                       Text(text = label)
                       Text(text = "${value}")

                   }
               }
               }
       }
       }
       Column { Text(text = "Macro-Nutriments",textAlign = TextAlign.Center, fontSize = 30.sp, fontWeight = FontWeight.Bold)
       macronutrimentsRow.forEach { macronutrimentsItem ->
           Row(modifier = Modifier.fillMaxWidth()) {
               macronutrimentsItem.forEach { (label, value) ->
                   Column(modifier = Modifier.padding(12.dp)) {
                       Text(text = label)
                       Text(text = "${value}")
                   }
               }
           }
       }
       }
       Column {  Text(text = "Minéraux",textAlign = TextAlign.Center, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        minerauxRow.forEach{minerauxItem ->
            Row (modifier=Modifier.fillMaxWidth()){
                minerauxItem.forEach{(label,value)->
                    Column (modifier=Modifier.padding(12.dp)){
                        Text(text = label)
                        Text(text = "${value}")
                    }
                }
            }

        }



       }
       Column  { Text(text = "Vitamine", textAlign = TextAlign.Center, fontSize = 30.sp, fontWeight = FontWeight.Bold)

       vitamineRow.forEach{ vitamineItem->
           Row(modifier=Modifier.fillMaxWidth()) {

               vitamineItem.forEach{(label,value)->
                   Column(modifier=Modifier.padding(12.dp)) {
                       Text(text = label)
                       Text(text = "${value}")
                   }
               }
           }
           }

       }
   }
}