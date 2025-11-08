package com.slyfly.nutrition.data.customerproductlist

import com.slyfly.nutrition.model.CustomerProductList.Category

import retrofit2.Call
import retrofit2.http.GET

interface CustomerProductListInterface {
@GET("nutrition/requete.php")
fun getNutrition(): Call<List<Category>>
}