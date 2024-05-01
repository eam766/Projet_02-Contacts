package com.example.projet_02_contacts.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EcranContacts(
    add: () -> Unit,
    details: () -> Unit,
    contViewModel: ContactViewModel,
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = {
            BarSup(title = "Mon Carnet")
        },
        floatingActionButton = {FloatingActionButton(
            onClick = {add()},
            Modifier.size(90.dp),
            shape = RoundedCornerShape(25.dp),
            containerColor = Color.Blue,
            contentColor = Color.White){
            Text(
                text = "+",
                style = MaterialTheme.typography.displaySmall
            )
        }}
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding),
        ){
            LazyColumn {
                items(contViewModel.getContenuListe()){
                        item-> UnContact(item, modifier, details, contViewModel)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}