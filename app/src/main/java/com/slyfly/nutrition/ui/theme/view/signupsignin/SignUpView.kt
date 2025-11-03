package com.slyfly.nutrition.ui.theme.view.signupsignin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slyfly.nutrition.function.Function
import com.slyfly.nutrition.ui.theme.NutritionTheme
import com.slyfly.nutrition.ui.theme.dancingScript


@Composable

fun SignUp() {
    Column (modifier=Modifier.fillMaxSize()
        .background(Function().functionGradientBlueToWhite())
    ) {

        Row(modifier=Modifier.fillMaxWidth()
            .padding(0.dp,100.dp,0.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
            ){
            Text(
                text = "Bienvenue sur\nNutrition",
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                lineHeight = 52.sp,
                fontFamily = dancingScript,
                fontWeight = FontWeight.Normal,

            )
        }
        Row(modifier=Modifier.fillMaxWidth()
            .padding(0.dp,50.dp,0.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center)
        {
OutlinedTextField(
    state= rememberTextFieldState(),
    label = {Text("Email")}
)
        }
        Row(modifier=Modifier.fillMaxWidth()
            .padding(0.dp,30.dp,0.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center)
        {
            OutlinedTextField(
                state= rememberTextFieldState(),
                label = {Text("Password")}
            )
        }
Row (modifier=Modifier.fillMaxWidth()
    .padding(0.dp,30.dp,0.dp,0.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center){
    Button(
        onClick = { /* TODO */ },

        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text(text = "Connexion")
    }
}
        Row(modifier=Modifier.fillMaxWidth()
            .padding(0.dp,30.dp,0.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){

            Text(text="Pas encore inscrit cliquez ici",
                fontFamily = dancingScript,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                modifier=Modifier.clickable { /*TODO*/ }
            )
        }

    }

}

@Preview(showBackground = true)

@Composable

fun GretingSignUp(){
NutritionTheme {
    SignUp()
}

}
