package com.example.mymviapplication.presentation.compose.catsScreen

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mymviapplication.R
import com.example.mymviapplication.data.model.modelCat.Data

@Composable
fun CatsCard(cat: Data) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        ConstraintLayout {
            val (tvUser) = createRefs()
            Text(text = cat.fact,
                color = colorResource(id = R.color.black),
                modifier = Modifier.constrainAs(tvUser) {
                    top.linkTo(parent.top, margin = 5.dp)
                    start.linkTo(parent.end, margin = 15.dp)
                })
        }
    }
}