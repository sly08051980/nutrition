package com.slyfly.nutrition.data.user.register

import com.slyfly.nutrition.data.user.RegisterResponse
import com.slyfly.nutrition.data.user.UserInfo
import com.slyfly.nutrition.data.user.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class ApiManager {
    private val api=ServiceBuilder.buildService((UserInterface::class.java))
    fun addUser(userData: UserInfo, onResult: (RegisterResponse?)->Unit){



        api.addUser(userData).enqueue(
            object : Callback<RegisterResponse> {
                override fun onFailure(call: Call<RegisterResponse>, t:Throwable){
onResult(null)
                }
                override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>){
                    if (response.isSuccessful){
                        onResult(response.body())
                    }else{
                        onResult(null)
                    }


                }
            }
        )
    }
}