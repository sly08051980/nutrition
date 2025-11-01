package com.slyfly.nutrition.model.CustomerProductList

data class Category(
    val categorie:String?,
val aliments:List<Aliments>
)
data class Aliments (
    val nom:String
)