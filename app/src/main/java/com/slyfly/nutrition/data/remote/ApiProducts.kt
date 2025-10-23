package com.slyfly.nutrition.data.remote

import com.slyfly.nutrition.model.findproduct.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiProducts {
    @GET("api/v2/product/{barcode}.json")
    fun getProduct(@Path("barcode") barcode: String): Call<ProductResponse>
}