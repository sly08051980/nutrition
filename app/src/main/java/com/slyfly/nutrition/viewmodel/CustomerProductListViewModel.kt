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

    private val _items = MutableStateFlow<List<ItemBody>>(emptyList())
    val items: StateFlow<List<ItemBody>> = _items

    private val _rawCategories = MutableStateFlow<List<Category>>(emptyList())
    val rawCategories: StateFlow<List<Category>> = _rawCategories

    var choiceName: String? = null
        private set

    fun selectCategory(name: String) {
        choiceName = name
        choiceAliments=null
    }

    var choiceAliments :String?=null
        private set

    fun selectAliment(name:String){
        choiceAliments=name
    }

    fun customerProductList(context: Context, onFinished: () -> Unit) {
        val api = ApiCustomerProductList(context)
        api.loadCustomerProductList { response: List<Category> ->
            // 1) on stocke les catégories brutes
            _rawCategories.value = response

            // 2) on map pour afficher la grille des catégories
            val mapped = response.map { cat ->
                val nom = cat.categorie ?: "Defaut"
                val imageResId = context.resources.getIdentifier(
                    nom.lowercase(), "drawable", context.packageName
                )
                ItemBody(
                    name = nom,
                    image = if (imageResId != 0) imageResId else R.drawable.produitvegetal
                )
            }
            _items.value = mapped

            onFinished()
        }
    }

    /** Construit les items d'aliments pour la catégorie sélectionnée */
    fun buildAlimentsForSelected(context: Context): List<ItemBody> {
        val selected = choiceName ?: return emptyList()
        val cat = _rawCategories.value.firstOrNull { it.categorie == selected }
        val aliments = cat?.aliments.orEmpty()
        return aliments.map { a ->
          val nomAlim = a.nom?: "Défaut"
            val imageResId = context.resources.getIdentifier(
                nomAlim.lowercase(), "drawable", context.packageName
            )
            ItemBody(
                name = nomAlim,
                image = if (imageResId != 0) imageResId else R.drawable.produitvegetal
            )
        }
    }
    fun buildAlimentsForSelectedAliment(context: Context): Aliments? {
      val catName=choiceName?: return null
        val alimName=choiceAliments ?:return null

        return _rawCategories.value.firstOrNull(){
            it.categorie ==catName
        }?.aliments?.firstOrNull{it.nom==alimName}
    }
}
