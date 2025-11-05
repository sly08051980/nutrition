package com.slyfly.nutrition.data.user.register

import com.slyfly.nutrition.data.user.UserInfo
import com.slyfly.nutrition.data.user.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class ApiManager {
    fun addUser(userData: UserInfo, onResult: (UserInfo?)->Unit){
        val retrofit = ServiceBuilder.buildService(UserInterface::class.java)
        retrofit.addUser(userData).enqueue(
            object : Callback<UserInfo> {
                override fun onFailure(call: Call<UserInfo>, t:Throwable){
onResult(null)
                }
                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>){
                    val addedUser=response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}