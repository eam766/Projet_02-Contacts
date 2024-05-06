package com.example.projet_02_contacts.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun EcranDetails(
    delete:() -> Unit,
    update:() -> Unit,
    back:() -> Unit,
    contViewModel: ContactViewModel
){
    val contUiState = contViewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            BarSupWithArrow(title = "Detail", onArrowClick = back, contViewModel = contViewModel)
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(Icons.Filled.Face, contentDescription = "", Modifier.size(230.dp))
            Text(
                text = "${contUiState.value.nom}, ${contUiState.value.prenom}",
                style = MaterialTheme.typography.displaySmall,
                overflow = TextOverflow.Clip,
                textAlign = TextAlign.Center
            )
            Text(
                //entreprise
                text = "Collège Ahuntsic"
            )
            Spacer(Modifier.height(30.dp))
            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.width(380.dp)) {
                Row{
                    Icon(Icons.Filled.Phone, contentDescription = "", Modifier.size(30.dp))
                    Spacer(Modifier.width(20.dp))
                    Text(text = contUiState.value.telephone)
                }
                Spacer(Modifier.height(15.dp))
                Row{
                    Icon(Icons.Filled.Email, contentDescription = "", Modifier.size(30.dp))
                    Spacer(Modifier.width(20.dp))
                    Text(text = contUiState.value.email)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ){
                Button(
                    onClick = {
                        contViewModel.delete(contUiState.value.id)
                        delete()
                              },
                    Modifier.size(90.dp),
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue)){
                    Icon(Icons.Filled.Delete, contentDescription = "")
                }
                Spacer(Modifier.width(20.dp))
                Button(
                    onClick = {update()},
                    Modifier.size(90.dp),
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue)){
                    Icon(Icons.Filled.Create, contentDescription = "")
                }
            }
        }
}   }