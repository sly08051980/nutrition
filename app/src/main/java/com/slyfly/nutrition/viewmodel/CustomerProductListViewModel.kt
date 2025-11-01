package com.slyfly.nutrition.viewmodel

import android.content.Context
import android.content.IntentSender.OnFinished
import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.ViewModel
import com.slyfly.nutrition.data.customerproductlist.ApiCustomerProductList
import com.slyfly.nutrition.model.CustomerProductList.Category
import com.slyfly.nutrition.model.ItemBody
import kotlinx.coroutines.flow.MutableStateFlow
import com.slyfly.nutrition.R
import com.slyfly.nutrition.model.CustomerProductList.Aliments
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map

class CustomerProductListViewModel : ViewModel() {
val TAG = "TEST"
    // On expose une LISTE d'items affichables (nom + drawable)
    private val _items = MutableStateFlow<List<ItemBody>>(emptyList())
    val items: StateFlow<List<ItemBody>> = _items

    // Optionnel: si tu veux aussi garder brut les Category renvoyées par l'API
    private val _rawCategories = MutableStateFlow<List<Category>>(emptyList())
    val rawCategories: StateFlow<List<Category>> = _rawCategories



    fun customerProductList(context: Context, onFinished: () -> Unit) {

        val api = ApiCustomerProductList(context)

        api.loadCustomerProductList { response: List<Category> ->
            // 1. On stocke les catégories brutes si besoin ailleurs
            _rawCategories.value = response

            // 2. On map chaque Category -> ItemBody pour l'affichage
            val mapped = response.map { cat ->
                val nom = cat.categorie?:"Defaut"

                // essaie de trouver un drawable du même nom
                val imageResId = context.resources.getIdentifier(
                    nom?.lowercase(),
                    "drawable",
                    context.packageName
                )



                ItemBody(
                    name = nom,
                    image = if (imageResId != 0) imageResId else R.drawable.produitvegetal,
                    onClick = {Log.i(TAG,nom)}
                )


            }

            // 3. On push ça dans le StateFlow observé par l’UI
            _items.value = mapped

            // 4. onFinished doit être APPELÉ, pas juste référencé
            onFinished()
        }
    }

}