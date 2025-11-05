package com.slyfly.nutrition.data.user

import com.slyfly.nutrition.data.UserInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserInterface {
    @Headers("Content-Type:application/json")
    @POST("nutrition/register.php")
    fun addUser(@Body userData: UserInfo): Call<UserInfo>


}
interface UserConnexion{
    @POST("nutrition/connexion.php")
    fun userConnexion(
        @Body userConnexion:UserConnexion): Call<UserConnexion>
}