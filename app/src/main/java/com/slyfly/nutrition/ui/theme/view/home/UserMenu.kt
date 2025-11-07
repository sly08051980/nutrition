package com.slyfly.nutrition.ui.theme.view.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable

fun UserMenu(){
Column(modifier = Modifier.fillMaxWidth(0.6f).fillMaxHeight(0.6f)) {
    Row(modifier=Modifier.fillMaxWidth()) {
Text(text = "Information Utilisateur")
    }
    Row {
        Text(text="Déconnexion")
    }
}
}

@Preview(showBackground = true)

@Composable
fun grettingUserMenu(){
    UserMenu()
}