package com.slyfly.nutrition.data.user.update

import com.slyfly.nutrition.data.user.ServiceBuilder
import com.slyfly.nutrition.data.user.UpdateResponse
import com.slyfly.nutrition.data.user.UpdateUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiUpdateUsers {
    private val api= ServiceBuilder.buildService(UserUpdateInterface::class.java)
    fun updateUser(userData:UpdateUser,onResult: (UpdateResponse?)->Unit){

        api.updateUser(userData).enqueue(
            object :Callback<UpdateResponse>{
                override fun onFailure (
                    call: Call<UpdateResponse>,
                   t:Throwable
                ) {
                    onResult(null)
                }

                override fun onResponse(call: Call<UpdateResponse>,response: Response<UpdateResponse>) {
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