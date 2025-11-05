package com.slyfly.nutrition.data.user.connexion

import com.slyfly.nutrition.data.user.ConnexionResponse
import com.slyfly.nutrition.data.user.ServiceBuilder
import com.slyfly.nutrition.data.user.UserConnexion
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiConnexionManager {

    private val api = ServiceBuilder.buildService(UserConnexionInterface::class.java)

    fun connexionUser(
        userConnexionData: UserConnexion,
        onResult: (ConnexionResponse?) -> Unit
    ) {
        api.connexionUser(userConnexionData).enqueue(object : Callback<ConnexionResponse> {

            override fun onFailure(call: Call<ConnexionResponse>, t: Throwable) {
                onResult(null)
            }

            override fun onResponse(
                call: Call<ConnexionResponse>,
                response: Response<ConnexionResponse>
            ) {
                if (response.isSuccessful) {
                    onResult(response.body())
                } else {
                    onResult(null)
                }
            }
        })
    }
}
