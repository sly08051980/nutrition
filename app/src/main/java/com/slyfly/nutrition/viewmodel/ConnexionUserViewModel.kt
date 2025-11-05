package com.slyfly.nutrition.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.slyfly.nutrition.data.user.UserConnexion
import com.slyfly.nutrition.data.user.connexion.ApiConnexionManager

class ConnexionUserViewModel : ViewModel() {

    var email: String by mutableStateOf("")
    var passwords: String by mutableStateOf("")

    private val userConnexion = ApiConnexionManager()

    fun isValidEmailSyntax(email: String): Boolean {
        val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+")
        return emailRegex.matches(email)
    }


    fun launchConnexionApi(onResult: (Boolean, String?) -> Unit) {

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
                onResult(true, result.message)
            } else {
                onResult(false, result?.message ?: "Erreur inconnue")
            }
        }
    }
}
