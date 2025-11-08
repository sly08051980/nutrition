package com.slyfly.nutrition.viewmodel.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slyfly.nutrition.data.datastore.ApplicationPref
import com.slyfly.nutrition.data.user.UserConnexion
import com.slyfly.nutrition.data.user.connexion.ApiConnexionManager
import kotlinx.coroutines.launch

const val KEY_IS_LOGGED="is_logged"
const val KEY_USER_ID="user_id"
const val KEY_USER_EMAIL="email_id"
const val KEY_USER_CITY="city_id"
const val KEY_USER_POSTALCODE="postalcode_id"
const val KEY_USER_FIRSTNAME="firstname_id"
const val KEY_USER_LASTNAME="lastname_id"
class ConnexionUserViewModel() : ViewModel() {

    var email: String by mutableStateOf("")
    var passwords: String by mutableStateOf("")
var firstName by mutableStateOf("")
    var lastName by mutableStateOf("")
    var city by mutableStateOf("")
    var postalCode by mutableStateOf("")
    var id by mutableStateOf("")

    private val userConnexion = ApiConnexionManager()



    fun isValidEmailSyntax(email: String): Boolean {
        val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+")
        return emailRegex.matches(email)
    }


    fun launchConnexionApi(
        appPref: ApplicationPref, onResult: (Boolean, String?) -> Unit) {

        if (passwords.isEmpty()) {
            onResult(false, "Mot de passe vide")
            return
        }

        if (!isValidEmailSyntax(email)) {
            onResult(false, "Email invalide")
            return
        }

        val connexionUser = UserConnexion(
            email = email,
            passwords = passwords
        )

        userConnexion.connexionUser(connexionUser) { result ->

            if (result != null && result.success) {

                viewModelScope.launch {
                    appPref.saveBooleanPref(KEY_IS_LOGGED,true)
                    result.user?.let{
                        user->
                        appPref.saveStringPref(KEY_USER_ID,user.id_users.toString())
                        appPref.saveStringPref(KEY_USER_EMAIL,user.email)
                        appPref.saveStringPref(KEY_USER_LASTNAME,user.lastName)
                        appPref.saveStringPref(KEY_USER_FIRSTNAME,user.firstName)
                        appPref.saveStringPref(KEY_USER_POSTALCODE,user.postalCode)
                        appPref.saveStringPref(KEY_USER_CITY,user.city)
                    }
                }
                onResult(true, result.message)
            } else {
                onResult(false, result?.message ?: "Erreur inconnue")
            }
        }
    }
   fun lauchDeconnexionApi(appPref: ApplicationPref, onResult: () -> Unit){
       viewModelScope.launch {
           appPref.saveBooleanPref(KEY_IS_LOGGED,false)
           appPref.saveStringPref(KEY_USER_ID,"")
           appPref.saveStringPref(KEY_USER_EMAIL,"")
           appPref.saveStringPref(KEY_USER_LASTNAME,"")
           appPref.saveStringPref(KEY_USER_FIRSTNAME,"")
           appPref.saveStringPref(KEY_USER_POSTALCODE,"")
           appPref.saveStringPref(KEY_USER_CITY,"")
           onResult()
       }



    }

    fun readUserDataStore(
        appPref: ApplicationPref,
        onResult: () -> Unit
    ) {
        viewModelScope.launch {

            id = appPref.getStringPref(KEY_USER_ID)?:""
            email = appPref.getStringPref(KEY_USER_EMAIL)?:""
            city = appPref.getStringPref(KEY_USER_CITY)?:""
            firstName = appPref.getStringPref(KEY_USER_FIRSTNAME)?:""
            lastName = appPref.getStringPref(KEY_USER_LASTNAME)?:""
            postalCode = appPref.getStringPref(KEY_USER_POSTALCODE)?:""

            onResult()
        }

    }

}
