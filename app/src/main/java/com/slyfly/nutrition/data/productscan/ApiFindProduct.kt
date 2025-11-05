package com.slyfly.nutrition.data.productscan

import android.content.Context
import android.util.Log
import com.slyfly.nutrition.model.barcode.BarCodeScanner
import com.slyfly.nutrition.model.findproduct.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFindProduct(val context: Context) {
    private val TAG:String = "CHECK_RESPONSE"
    private val TAG3:String="CHECK_RESPONSE_3"

    private val BASE_URL="https://fr.openfoodfacts.org/"
    fun loadProduct(onResult:(ProductResponse?)->Unit){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiProductsInterface::class.java)
        val barCodeScanner= BarCodeScanner(context)
        barCodeScanner.startScanner{result ->

        api.getProduct(result?:"Null").enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    onResult(response.body())
                    val body = response.body()
                    val p = body?.product
                    val n=p?.nutriments

                    Log.i(TAG3,
                        //"produit=${p?.product_name}, marque=${p?.brands}" +
                                ",nom complet=${p?.abbreviated_product_name_fr}"+
                                "Type d allergie=${p?.allergens_from_ingredients}"+
                                //"Allergie =${p?.allergens_from_user}"+"Type de plat =${p?.categories_old}"+
                                "Conservation =${p?.conservation_conditions_fr}"+
                                "Fabrication = ${p?.countries_imported}"+
                                "Image = ${p?.image_front_url}"
                                +"ingredient=${p?.ingredients_text_fr}" +
                                "nutriscrore=${p?.nutrition_grade_fr}"+
                                "glucides pour 100 g=${n?.carbohydrates_100g}g"+
                                "calories=${n?.energy_kcal_100g}"+
                                "Kjoule = ${n?.energy_kj_100g}"+
                                "Graisse =${n?.fat_100g}"+
                                "Fibre = ${n?.fiber_100g}" +
                                "Proteine = ${n?.proteins_100g}"+
                                "Sel =${n?.salt_100g}"+
                                "Graisse saturé = ${n?.saturated_fat_100g}" +
                                "Sodium=${n?.sodium_100g}" +
                                "Sucre =${n?.sugars_100g}"+
                                "Preparation =${p?.preparation_fr}"+
                                "Poids = ${p?.product_quantity}"+"${p?.product_quantity_unit}")

                } else {
                    Log.i(TAG3, "HTTP ${response.code()} : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}", t)
            }
        })
    }
    }
}