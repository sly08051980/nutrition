import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slyfly.nutrition.data.remote.ApiFindProduct
import com.slyfly.nutrition.model.findproduct.Product
import com.slyfly.nutrition.model.findproduct.ProductResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ResultScannerViewModel : ViewModel() {

    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product

    fun scanAndFetchProduct(context: Context) {
        val api = ApiFindProduct(context)

        api.loadProduct { response ->
            val prod = response?.product
            _product.value = prod
        }
    }
}