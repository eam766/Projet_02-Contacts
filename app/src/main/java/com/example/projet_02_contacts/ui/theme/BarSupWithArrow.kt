package com.example.projet_02_contacts.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BarSupWithArrow(
    modifier: Modifier = Modifier,
    title: String,
    onArrowClick: () -> Unit,
    contViewModel: ContactViewModel
){
    Row(modifier = modifier
        .fillMaxWidth()
        .height(75.dp)
        .background(color = Color.Blue)
        .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            Icons.Filled.ArrowBack,
            contentDescription = "",
            modifier = Modifier.size(40.dp)
                .clickable {
                    onArrowClick.invoke()
                    contViewModel.resetAll()
                           },
            tint = Color.White
        )
        Spacer(Modifier.width(15.dp))
        Text(
            text = title,
            color = Color.White,
            style = MaterialTheme.typography.displaySmall
        )
    }
}