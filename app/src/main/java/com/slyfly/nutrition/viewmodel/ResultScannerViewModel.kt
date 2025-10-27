import android.content.Context
import androidx.lifecycle.ViewModel
import com.slyfly.nutrition.data.productscan.ApiFindProduct
import com.slyfly.nutrition.model.findproduct.Nutriments
import com.slyfly.nutrition.model.findproduct.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ResultScannerViewModel : ViewModel() {

    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product
private val _nutriment=MutableStateFlow<Nutriments?>(null)
    val nutriment:StateFlow<Nutriments?> = _nutriment
    fun scanAndFetchProduct(context: Context,onFinished: ()-> Unit) {
        val api = ApiFindProduct(context)

        api.loadProduct { response ->
            val prod = response?.product
            val nut = prod?.nutriments
            _product.value = prod
            _nutriment.value=nut
            
            onFinished()
        }
    }
}