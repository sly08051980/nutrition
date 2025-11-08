package com.slyfly.nutrition.ui.theme.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.slyfly.nutrition.data.datastore.ApplicationPref
import com.slyfly.nutrition.function.Function
import com.slyfly.nutrition.ui.theme.view.View
import com.slyfly.nutrition.viewmodel.users.ConnexionUserViewModel


@Composable

fun UserMenu(modifier: Modifier=Modifier, vm: ConnexionUserViewModel, navController: NavHostController){
  //  var expanded by remember { mutableStateOf(false) }
val context = LocalContext.current
    val appPref= ApplicationPref(context)

    Box(
        modifier = modifier
            .background(Function().functionGradientBlueToWhite())
            .fillMaxHeight()
            .fillMaxWidth(0.6f)
    ){
        Column {
            Row { Text(text = "Information personnelle") }
            Row { Text(text="Déconnexion",modifier=Modifier.clickable {
                vm.lauchDeconnexionApi(appPref){
                    navController.navigate(View.SignUpView.title)
                }
            }
                )

                 }
        }

    }
}

@Preview(showBackground = true)

@Composable
fun grettingUserMenu(){
   // UserMenu()
}