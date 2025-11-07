package com.slyfly.nutrition.ui.theme.view.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import com.slyfly.nutrition.R


import androidx.compose.material3.CenterAlignedTopAppBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


import com.slyfly.nutrition.ui.theme.view.View
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.slyfly.nutrition.function.Function




@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun AppBarView( navController: NavHostController,onUserClick:()->Unit) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val canNavigateBack = navController.previousBackStackEntry != null
    val isHome = backStackEntry?.destination?.route == View.HomeView.title

    Box{
        CenterAlignedTopAppBar(

            title = { Text(text = "Nutrition",
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
                 
                )
            },

            navigationIcon = {
                if (!isHome && canNavigateBack) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            },

            actions = {
                IconButton(onClick = { onUserClick() }) {
                    Icon(

                        painter = painterResource(R.drawable.person),
                        contentDescription = "signout",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
            },


                modifier = Modifier.background(Function().functionGradientWhiteToBlue()),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent
            )
        )       





    }








}
@Composable
fun ScaffoldComposable() {
    val navController = rememberNavController()
    Scaffold(
        //passe le navcontroller a l appbar
        topBar = { AppBarView(
            navController,
            onUserClick = {}
        ) },
        content = {  }
    )
}
@Preview(showBackground = true)
@Composable
fun gretPrewiev(){
   ScaffoldComposable()
}