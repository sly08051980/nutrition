package com.slyfly.nutrition.ui.theme.view.scanner

import ResultScannerViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import com.slyfly.nutrition.ui.theme.NutriscoreA
import com.slyfly.nutrition.ui.theme.NutriscoreB
import com.slyfly.nutrition.ui.theme.NutriscoreC
import com.slyfly.nutrition.ui.theme.NutriscoreD
import com.slyfly.nutrition.ui.theme.NutriscoreE

import java.util.Locale

@Composable
fun ScannerResultView(vm: ResultScannerViewModel = viewModel()) {

    val product by vm.product.collectAsState()
    val nutriment by vm.nutriment.collectAsState()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) { AsyncImage(
            model = product?.image_front_url,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Spacer(Modifier.height(16.dp))

Text(text="Code Barre: ${product?._id}")
        Text(text = "Nom: ${product?.product_name} Marque: ${product?.brands}")
        Text(text = "Dénomination complète: ${product?.abbreviated_product_name_fr}")
        Text(text = "Poids: ${product?.product_quantity} ${product?.product_quantity_unit}")
        Text(text = "Origine: ${product?.countries_imported}")
        Text(text = "Allergène (déclaré): ${product?.allergens_from_user}")
        Text(text = "Allergène (ingrédients): ${product?.allergens_from_ingredients}")
        Text(text = "Ingrédients: ${product?.ingredients_text_fr}")
        val nutri=product?.nutrition_grade_fr
       when(nutri){
           "a"->Text(text = "Nutriscore: "+(product?.nutrition_grade_fr)?.toUpperCase(Locale.ROOT), color =NutriscoreA)
           "b"->Text(text = "Nutriscore: "+(product?.nutrition_grade_fr)?.toUpperCase(Locale.ROOT), color = NutriscoreB)
           "c"->Text(text = "Nutriscore: "+(product?.nutrition_grade_fr)?.toUpperCase(Locale.ROOT), color = NutriscoreC)
           "d"->Text(text = "Nutriscore: "+(product?.nutrition_grade_fr)?.toUpperCase(Locale.ROOT), color = NutriscoreD)
           "e"->Text(text = "Nutriscore: "+(product?.nutrition_grade_fr)?.toUpperCase(Locale.ROOT), color = NutriscoreE)
       }


        Spacer(Modifier.height(16.dp))


        Text(text = "Valeurs pour 100g")

        Spacer(Modifier.height(8.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Glucides")
                    Text(text = "${nutriment?.carbohydrates_100g} g")
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Graisse totale")
                    Text(text = "${nutriment?.fat_100g} g")
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Graisse saturée")
                    Text(text = "${nutriment?.saturated_fat_100g} g")
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Sucres")
                    Text(text = "${nutriment?.sugars_100g} g")
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Sel")
                    Text(text = "${nutriment?.salt_100g} g")
                }
            }

            Spacer(modifier = Modifier.width(32.dp))


            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Sodium")
                    Text(text = "${nutriment?.sodium_100g} g")
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Fibres")
                    Text(text = "${nutriment?.fiber_100g} g")
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Protéines")
                    Text(text = "${nutriment?.proteins_100g} g")
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Énergie (kcal)")
                    Text(text = "${nutriment?.energy_kcal_100g} kcal")
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Énergie (kJ)")
                    Text(text = "${nutriment?.energy_kj_100g} kJ")
                }
            }
        }

        Spacer(Modifier.height(16.dp))


        Text(text = "Conservation: ${product?.conservation_conditions_fr}")
        Text(text = "Préparation: ${product?.preparation_fr}")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScaner() {
    ScannerResultView()
}
