package com.slyfly.nutrition.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.slyfly.nutrition.data.user.UserInfo
import com.slyfly.nutrition.data.user.register.ApiManager

class RegisterViewModel:ViewModel() {

    var firstName:String by mutableStateOf("")
var lastName:String by mutableStateOf("")
 var postalCode:String by mutableStateOf("")
    var city:String by mutableStateOf("")
    var email:String by mutableStateOf("")
    var passwords by mutableStateOf("")
var confirmPasswords by mutableStateOf("")

    val apiService= ApiManager()

    fun isValidEmailSyntax(email: String): Boolean {
        val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+")
        return emailRegex.matches(email)
    }
    fun isValidPostalCode(postalCode:String):Boolean{
       val postalCodeLength={postalCode.length==5}
        return postalCodeLength()
    }
    fun launchApi(onResult: (Boolean,String)->Unit){
        if (passwords !=confirmPasswords){
            onResult(false,"les mots de passe ne sont pas identique")
            return
        }
        if (isValidEmailSyntax(email) && isValidPostalCode(postalCode)){


val userInfo= UserInfo(
    id_users=null,
    firstName=firstName.trim().lowercase(),
    lastName=lastName.trim().lowercase(),
    postalCode=postalCode,
    city=city.trim().lowercase(),
    email=email.trim().lowercase(),
    passwords=passwords
)
        apiService.addUser(userInfo){result->
           if (result!=null && result.success){
               onResult(true,result.message)
           }else{
               onResult(false,result?.message ?: "Erreur lors de l inscription")
           }
        }
        }
    }
}