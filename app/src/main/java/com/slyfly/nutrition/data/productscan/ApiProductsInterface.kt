package com.slyfly.nutrition.data.productscan

import com.slyfly.nutrition.model.findproduct.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiProductsInterface {
    @GET("api/v2/product/{barcode}.json")
    fun getProduct(@Path("barcode") barcode: String): Call<ProductResponse>
}