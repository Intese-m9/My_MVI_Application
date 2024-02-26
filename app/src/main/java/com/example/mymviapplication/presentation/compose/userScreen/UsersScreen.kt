package com.example.mymviapplication.presentation.compose.userScreen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.mymviapplication.presentation.compose.stateScreen.ErrorScreen
import com.example.mymviapplication.presentation.compose.stateScreen.LoadingScreen
import com.example.mymviapplication.presentation.viewmodel.MainViewModel

@Composable
fun UsersScreen(mainViewModel: MainViewModel) {
    val data = mainViewModel.getUsersPagination().collectAsLazyPagingItems()
    Column {
        Text(
            text = "RandomDataUsers",
            fontWeight = FontWeight(900),
            fontFamily = FontFamily.Cursive,
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
        )
        LazyColumn {
            items(data) { user ->
                user?.let { UserCard(user = it) }
            }
            item {
                when (data.loadState.refresh) {
                    is LoadState.Error -> {
                        ErrorScreen()
                    }

                    is LoadState.Loading -> {
                        LoadingScreen()
                    }

                    else -> {}
                }
            }
        }
    }
}
