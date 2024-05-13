package com.example.projet_02_contacts.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EcranAjouter(
    create: () -> Unit,
    back:() -> Unit,
    contViewModel: ContactViewModel
){
    Scaffold(
        topBar = {
            BarSupWithArrow(title = "Ajouter", onArrowClick = back, contViewModel = contViewModel)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Icon(Icons.Filled.Face, contentDescription = "", Modifier.size(230.dp))
            Row (modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Filled.Person, contentDescription = "", Modifier.size(30.dp))
                Spacer(Modifier.width(20.dp))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = contViewModel.getNom(),
                    onValueChange = {contViewModel.updateNom(it)},
                    label = { Text(text = "Nom: ") },
                    trailingIcon = {
                        Icon(
                            Icons.Default.Clear,
                            contentDescription = "clear text",
                            modifier = Modifier
                                .clickable {
                                    contViewModel.resetNom()
                                }
                        )
                    }
                )
            }
            Row (modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Filled.Person, contentDescription = "", Modifier.size(30.dp))
                Spacer(Modifier.width(20.dp))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = contViewModel.getPrenom(),
                    onValueChange = {contViewModel.updatePrenom(it)},
                    label = { Text(text = "Prénom: ") },
                    trailingIcon = {
                        Icon(
                            Icons.Default.Clear,
                            contentDescription = "clear text",
                            modifier = Modifier
                                .clickable {
                                    contViewModel.resetPrenom()
                                }
                        )
                    }
                )
            }
            Row (modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Filled.Phone, contentDescription = "", Modifier.size(30.dp))
                Spacer(Modifier.width(20.dp))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = contViewModel.getTelephone(),
                    onValueChange = {contViewModel.updateTelephone(it)},
                    label = { Text(text = "Téléphone: ") },
                    trailingIcon = {
                        Icon(
                            Icons.Default.Clear,
                            contentDescription = "clear text",
                            modifier = Modifier
                                .clickable {
                                    contViewModel.resetTelephone()
                                }
                        )
                    }
                )
            }
            Row (modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Filled.Phone, contentDescription = "", Modifier.size(30.dp))
                Spacer(Modifier.width(20.dp))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = contViewModel.getMobile(),
                    onValueChange = {contViewModel.updateMobile(it)},
                    label = { Text(text = "Mobile: ") },
                    trailingIcon = {
                        Icon(
                            Icons.Default.Clear,
                            contentDescription = "clear text",
                            modifier = Modifier
                                .clickable {
                                    contViewModel.resetMobile()
                                }
                        )
                    }
                )
            }
            Row (modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Filled.Email, contentDescription = "", Modifier.size(30.dp))
                Spacer(Modifier.width(20.dp))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = contViewModel.getCourriel(),
                    onValueChange = {contViewModel.updateCourriel(it)},
                    label = { Text(text = "Courriel: ") },
                    trailingIcon = {
                        Icon(
                            Icons.Default.Clear,
                            contentDescription = "clear text",
                            modifier = Modifier
                                .clickable {
                                    contViewModel.resetCourriel()
                                }
                        )
                    }
                )
            }
            Row (modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Filled.LocationOn, contentDescription = "", Modifier.size(30.dp))
                Spacer(Modifier.width(20.dp))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = contViewModel.getAdresse(),
                    onValueChange = {contViewModel.updateAdresse(it)},
                    label = { Text(text = "Adresse: ") },
                    trailingIcon = {
                        Icon(
                            Icons.Default.Clear,
                            contentDescription = "clear text",
                            modifier = Modifier
                                .clickable {
                                    contViewModel.resetAdresse()
                                }
                        )
                    }
                )
            }
            Row (modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Filled.Home, contentDescription = "", Modifier.size(30.dp))
                Spacer(Modifier.width(20.dp))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = contViewModel.getEntreprise(),
                    onValueChange = {contViewModel.updateEntreprise(it)},
                    label = { Text(text = "Entreprise: ") },
                    trailingIcon = {
                        Icon(
                            Icons.Default.Clear,
                            contentDescription = "clear text",
                            modifier = Modifier
                                .clickable {
                                    contViewModel.resetEntreprise()
                                }
                        )
                    }
                )
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
                        contViewModel.add()
                        create()
                        contViewModel.resetAll()
                              },
                    Modifier.size(90.dp),
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue)){
                    Icon(Icons.Filled.Check, contentDescription = "")
                }
                Spacer(Modifier.width(20.dp))
                Button(
                    onClick = {
                        contViewModel.resetAll()
                    },
                    Modifier.size(90.dp),
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(Color.Blue)){
                    Icon(Icons.Filled.Clear, contentDescription = "")
                }
            }
        }
    }
}