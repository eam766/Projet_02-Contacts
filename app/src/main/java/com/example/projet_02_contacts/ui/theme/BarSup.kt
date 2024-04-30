package com.example.projet_02_contacts.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BarSup(
    modifier: Modifier = Modifier,
    title: String
){
    Row(modifier = modifier
        .fillMaxWidth()
        .height(75.dp)
        .background(color = Color.Blue)
        .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Spacer(Modifier.width(10.dp))
        Text(
            text = title,
            color = Color.White,
            style = MaterialTheme.typography.displaySmall
        )
    }
}