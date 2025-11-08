package com.slyfly.nutrition.ui.theme.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.slyfly.nutrition.R
import com.slyfly.nutrition.data.datastore.ApplicationPref
import com.slyfly.nutrition.function.Function
import com.slyfly.nutrition.ui.theme.view.View
import com.slyfly.nutrition.viewmodel.users.ConnexionUserViewModel


@Composable

fun UserMenu(modifier: Modifier=Modifier,
             vm: ConnexionUserViewModel,
             navController: NavHostController,
             onCloseMenu: () -> Unit){

val context = LocalContext.current
    val appPref= ApplicationPref(context)

    Box(
        modifier = modifier
            .background(Function().functionGradientBlueToWhite())
            .fillMaxHeight()
            .fillMaxWidth(0.6f)
    ){
        Column {
            Row {
Icon(painter = painterResource(id= R.drawable.personalinfo), contentDescription = "info perso",modifier=Modifier.size(25.dp))

                Text(text = "Information personnelle",
                modifier=Modifier
                    .padding(start=10.dp)
                    .clickable {

                vm.readUserDataStore(appPref){
                    onCloseMenu()
                    navController.navigate(View.Update.title)
                }

            }) }
            Spacer(modifier = Modifier.height(25.dp))
            Row {
Icon(painter = painterResource(id=R.drawable.signout), contentDescription = "sign out", modifier = Modifier.size(25.dp))
                Text(text="Déconnexion",modifier=Modifier
                    .padding(start = 10.dp)
                    .clickable {
                vm.lauchDeconnexionApi(appPref){
                    onCloseMenu()
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