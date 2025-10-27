package com.slyfly.nutrition.data

import android.content.Context
import androidx.navigation.NavController
import com.slyfly.nutrition.R
import com.slyfly.nutrition.data.customerproductlist.ApiCustomerProductList
import com.slyfly.nutrition.data.productscan.ApiFindProduct
import com.slyfly.nutrition.model.ItemBody
import com.slyfly.nutrition.ui.theme.view.View


class DataItemBody(private val context: Context){
        val apiFindProduct= ApiFindProduct(context)
    val apiCustomerProductList=ApiCustomerProductList(context)

    val scanner = ItemBody(name = "Scanner", image = R.drawable.codebarre)
    val scannermescourse=ItemBody(name ="Scanner mes Courses", image =R.drawable.listedecourse
)
    val repasDuJours=ItemBody(name ="Repas du Jours", image =R.drawable.repas, onClick = { /*TODO*/ })

    fun allItemBody():List<ItemBody>{

        return listOf(scanner,scannermescourse,repasDuJours)
    }
}


