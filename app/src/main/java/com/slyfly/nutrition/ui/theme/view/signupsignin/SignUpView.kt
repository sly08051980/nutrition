package com.slyfly.nutrition.ui.theme.view.signupsignin

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.slyfly.nutrition.function.Function
import com.slyfly.nutrition.ui.theme.NutritionTheme
import com.slyfly.nutrition.ui.theme.dancingScript
import com.slyfly.nutrition.ui.theme.view.View


@Composable

fun SignUpView(navController: NavController) {
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
                fontSize = 70.sp,
                lineHeight = 62.sp,
                fontFamily = dancingScript,
                fontWeight = FontWeight.Normal,

            )
        }
        Row(modifier=Modifier.fillMaxWidth()

            .padding(0.dp,50.dp,0.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center)
        {
            val email = rememberTextFieldState()

            OutlinedTextField(
                state = email,
                label = { Text("Email") },
               
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )
        }
        Row(modifier=Modifier.fillMaxWidth()
            .padding(0.dp,30.dp,0.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center)
        {
            val password = rememberTextFieldState()

            OutlinedTextField(
                state = password,
                label = { Text("Mot de Passe") },

                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
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
                fontSize = 30.sp,
                modifier=Modifier.clickable { navController.navigate(View.SignInView.title) }
            )
        }

    }

}

@Preview(showBackground = true)

@Composable

fun GretingSignUp(){
NutritionTheme {
    val navController = rememberNavController()
    SignUpView(navController=navController)
}

}
