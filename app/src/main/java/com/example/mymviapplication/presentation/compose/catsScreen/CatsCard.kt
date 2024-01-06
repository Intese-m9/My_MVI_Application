package com.example.mymviapplication.presentation.compose.catsScreen

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.mymviapplication.R
import com.example.mymviapplication.data.model.modelCat.Data

@Composable
fun CatsCard(cat: Data) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .fillMaxHeight()
    ) {
        Text(
            modifier = Modifier
                .padding(35.dp),
            text = cat.fact, color = colorResource(id = R.color.black)
        )
    }
}