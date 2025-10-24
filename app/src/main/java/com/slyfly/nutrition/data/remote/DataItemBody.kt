package com.slyfly.nutrition.data.remote

import android.content.Context
import com.slyfly.nutrition.R
import com.slyfly.nutrition.model.ItemBody


class DataItemBody(private val context: Context){
        val apiFindProduct=ApiFindProduct(context)

    val scanner = ItemBody(name = "Scanner", image = R.drawable.codebarre,  onClick = { apiFindProduct.loadProduct{} } )
    val listProduit=ItemBody(name ="Liste Produit", image =R.drawable.listedecourse, onClick = {/*TODO*/})
    val repasDuJours=ItemBody(name ="Repas du Jours", image =R.drawable.repas, onClick = { /*TODO*/ })

    fun allItemBody():List<ItemBody>{

        return listOf(scanner,listProduit,repasDuJours)
    }
}

