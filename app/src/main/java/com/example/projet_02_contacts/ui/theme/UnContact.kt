package com.example.projet_02_contacts.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.projet_02_contacts.modele.Contact

@Composable
fun UnContact(
    contact: Contact,
    modifier: Modifier = Modifier,
    details: () -> Unit,
    contViewModel: ContactViewModel){
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
                contViewModel.showDetails(contact)
                details.invoke()
            }
    ){
        Row(modifier = Modifier
            .height(80.dp)
            .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(Icons.Filled.Face, contentDescription = "", Modifier.size(70.dp))
            Spacer(Modifier.width(5.dp))
            Text(text = "${contact.nom}, ${contact.prenom}")
        }
    }
}