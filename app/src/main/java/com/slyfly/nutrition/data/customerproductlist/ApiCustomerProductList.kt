package com.slyfly.nutrition.data.customerproductlist

import android.content.Context
import android.nfc.Tag
import android.util.Log
import com.slyfly.nutrition.model.CustomerProductList.Category
import com.slyfly.nutrition.model.CustomerProductList.CustomerProductListResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCustomerProductList(val context: Context) {

    val TAG:String="CHECK_RESPONSE_CUSTOMER"
    val TAG1:String="CHECK_RESPONSE_CUSTOMER1"
    val TAG2:String="CHECK_RESPONSE_CUSTOMER2"
    private val BASE_URL="https://regniersylvain.ngravecreations.com/"

    fun loadCustomerProductList(onResult: (List<Category>)->Unit){

        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()



        val api= retrofit.create(CustomerProductList::class.java)



        api.getNutrition().enqueue(object : Callback<List<Category>> {

            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
               // Log.i(TAG, "code HTTP = ${response.code()}, success=${response.isSuccessful}")
              //  Log.i(TAG, "raw = ${response.raw()}")

                if (response.isSuccessful) {

                    response.body()?.let { onResult(it) }


                    val body = response.body()


                    body?.forEach{
                        cat->
                        cat.categorie?.let { Log.i(TAG, it) }
                        cat.aliments.let { Log.i(TAG1,cat.categorie + cat.aliments.toString()) }


                    }




                } else {
                    Log.e(TAG, "ERREUR SERVEUR : ${response.errorBody()?.string()}")
                }
            }



            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Log.e(TAG1, "onFailure: ${t.message}", t)
            }

        })

}
}
