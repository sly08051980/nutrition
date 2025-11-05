package com.slyfly.nutrition.data.user.connexion

import com.slyfly.nutrition.data.user.ConnexionResponse
import com.slyfly.nutrition.data.user.UserConnexion
import com.slyfly.nutrition.data.user.UserInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserConnexionInterface {
    @Headers("Content-Type:application/json")
    @POST("nutrition/userConnexion.php")
    fun connexionUser(@Body userConnexionData: UserConnexion):Call<ConnexionResponse>
}