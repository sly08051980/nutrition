package com.slyfly.nutrition.data.user.update


import com.slyfly.nutrition.data.user.UpdateResponse
import com.slyfly.nutrition.data.user.UpdateUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserUpdateInterface {
    @Headers("Content-Type:application/json")
    @POST("nutrition/update.php")
    fun updateUser(@Body updateDataUser : UpdateUser): Call<UpdateResponse>
}