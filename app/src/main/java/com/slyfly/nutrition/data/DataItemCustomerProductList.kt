package com.slyfly.nutrition.data

import android.content.Context
import com.slyfly.nutrition.data.customerproductlist.ApiCustomerProductList
import com.slyfly.nutrition.model.ItemBody
import com.slyfly.nutrition.R

class DataItemCustomerProductList(val context: Context) {


    val scanner = ItemBody(name="Scanner",image=R.drawable.codebarre)
    val defaultItems = listOf(scanner)

    fun allItemCustomerProductList(): List<Any> {
        return listOf(scanner,defaultItems)
    }

}
