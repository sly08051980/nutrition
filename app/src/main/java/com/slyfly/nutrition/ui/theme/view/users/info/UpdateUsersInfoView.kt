package com.slyfly.nutrition.ui.theme.view.users.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slyfly.nutrition.data.datastore.ApplicationPref
import com.slyfly.nutrition.function.Function
import com.slyfly.nutrition.ui.theme.dancingScript
import com.slyfly.nutrition.viewmodel.users.ConnexionUserViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue



@Composable
fun UpdateUserInfoView(vm: ConnexionUserViewModel) {

    val context = LocalContext.current
    val appPref = remember { ApplicationPref(context) }

//charge les donnée a l ouverture
    LaunchedEffect(Unit) {
        vm.readUserDataStore(appPref) {  }
    }
//pour l alertdialog
    var showDialog by remember { mutableStateOf(false) }

    val user= listOf(
        "email" to vm.email,
        "Prenom" to vm.firstName,
        "Nom" to vm.lastName,
        "Ville" to vm.city,
        "Code Postal" to vm.postalCode
    )



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Function().functionGradientBlueToWhite())
            .imePadding()
            .verticalScroll(rememberScrollState())
    ) {
        Row(modifier=Modifier.fillMaxWidth()) {
            Text(text = "Modifier mes Informations",fontSize=50.sp, fontFamily = dancingScript, fontWeight = FontWeight.Normal,
                lineHeight = 50.sp, textAlign = TextAlign.Center)
        }

Spacer(Modifier.size(50.dp))
        user.forEach{(label,value)->
            Row(
                modifier=Modifier.fillMaxWidth()
                    .padding(top=10.dp),
                verticalAlignment=Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                OutlinedTextField(
                    value=value,
                    onValueChange = {newValue->
                        when(label){
                            "Email"->vm.email=newValue
                            "Prénom" -> vm.firstName = newValue
                            "Nom" -> vm.lastName = newValue
                            "Ville" -> vm.city = newValue
                            "Code Postal" -> vm.postalCode = newValue
                        }
                    },
                    label={Text(label)},
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

        }
        Row (modifier=Modifier.fillMaxWidth().padding(top=40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly){
            ElevatedButton(onClick = {/*TODO*/},modifier=Modifier.width(150.dp)
                .height(58.dp)) {
                Text("Quitter" , fontSize = 25.sp, fontFamily = dancingScript,
                    fontWeight = FontWeight.Normal,)
            }
            ElevatedButton(onClick = {  showDialog = true },modifier=Modifier.width(150.dp)
                .height(58.dp)) {
                Text("Modifier",fontSize=25.sp, fontFamily = dancingScript,
                    fontWeight = FontWeight.Normal,)
            }
        }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                onConfirmation = {
                    showDialog = false
                    // api update
                },
                dialogTitle = "Confirmation",
                dialogText = "Souhaitez-vous enregistrer les modifications ?",
                icon = Icons.Default.Info
            )
        }

    }
}
@Composable
fun AlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Valider")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Annuler")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GrettingUserInfo() {

}
