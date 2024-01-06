package com.example.mymviapplication.presentation.compose.userScreen

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.mymviapplication.R
import com.example.mymviapplication.data.model.modelUser.User

@Composable
fun UserCard(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        ConstraintLayout {
            val (imIcon, tvUser, tvMail) = createRefs()
            AsyncImage(contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(imIcon) {
                        top.linkTo(parent.top, margin = 5.dp)
                        start.linkTo(parent.start, margin = 5.dp)
                        bottom.linkTo(parent.bottom, margin = 5.dp)
                    }
                    .size(50.dp)
                    .clip(CircleShape),
                model = user.avatar,
                error = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null)
            Text(text = user.name,
                color = colorResource(id = R.color.black),
                modifier = Modifier.constrainAs(tvUser) {
                        top.linkTo(parent.top, margin = 5.dp)
                        start.linkTo(imIcon.end, margin = 15.dp)
                    })
            Text(text = user.email,
                color = colorResource(id = R.color.black),
                modifier = Modifier.constrainAs(tvMail) {
                        top.linkTo(tvUser.bottom, margin = 10.dp)
                        start.linkTo(imIcon.end, margin = 15.dp)
                        bottom.linkTo(parent.bottom, margin = 5.dp)
                    })
        }
    }
}