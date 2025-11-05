package com.slyfly.nutrition.viewmodel

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.slyfly.nutrition.data.UserInfo
import com.slyfly.nutrition.data.user.ApiManager

class Register:ViewModel() {

    var firstName:String by mutableStateOf("")
var lastName:String by mutableStateOf("")
 var postalCode:String by mutableStateOf("")
    var city:String by mutableStateOf("")
    var email:String by mutableStateOf("")
    var passwords by mutableStateOf("")


    val apiService=ApiManager()
    val userInfo=UserInfo(
        id=null,
        firstName=firstName,
        lastName = "",
        postalCode="",
        city = "",
        email = "",
        passwords = ""
    )

    fun updateTextfieldValue(text:String){
        firstName=text,

    }
    apiService.addUser(userInfo){
        if (it?.id !=null){
            it?.id = newly added user ID
        }else{
            Toast("Impossible d'enregistrer")
        }
    }
}