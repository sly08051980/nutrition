package com.slyfly.nutrition.model.CustomerProductList

data class Category(
    val categorie:String?,
val aliments:List<Aliments>
)
data class Aliments (
    val nom:String?,
    val id:Int?,
    val fer:Double?,
    val iode:Double?,
    val kcal:Double?,
    val zinc:Double?,
    val cuivre:Double?,
    val fibres:Double?,
    val sodium:Double?,
    val sucres:Double?,
    val calcium:Double?,
    val lipides:Double?,
    val selenium:Double?,
    val magnesium:Double?,
    val manganese:Double?,
    val phosphore:Double?,
    val potassium:Double?,
    val proteines:Double?,
    val vitamine_a:Double?,
    val vitamine_c:Double?,
    val vitamine_d:Double?,
    val vitamine_e:Double?,
    val vitamine_k:Double?,
    val vitamine_b1:Double?,
    val vitamine_b2:Double?,
    val vitamine_b3:Double?,
    val vitamine_b5:Double?,
    val vitamine_b6:Double?,
    val vitamine_b7:Double?,
    val vitamine_b9:Double?,
    val vitamine_b12:Double?,
    val poid_unite_g:Double?,
    val kcal_par_unite:Double?,
    val imageResId:Int

)