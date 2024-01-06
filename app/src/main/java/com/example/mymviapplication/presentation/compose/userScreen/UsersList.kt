package com.example.mymviapplication.presentation.compose.userScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mymviapplication.data.model.modelUser.User
private const val TT = 20
@Composable
fun UsersList(userList: List<User>) {
    Column {
        Text(
            text = "RandomData",
            fontWeight = FontWeight(900),
            fontFamily = FontFamily.Cursive,
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
        )
        LazyColumn{
            items(items = userList.take(TT)) { users ->
                UserCard(user = users)
            }
        }
    }
}
