package com.ilya.sporttest.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ilya.sporttest.presentation.MainViewModel

@Composable
fun MatchCard(viewModel: MainViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 2.dp,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Лига",
                color = MaterialTheme.colors.onPrimary
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )
                    Text(
                        text = "Название команды",
                        color = MaterialTheme.colors.onPrimary
                    )
                }

                Text(
                    text = "1 : 1",
                    color = MaterialTheme.colors.onPrimary
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )
                    Text(
                        text = "Название команды",
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//private fun PreviewLight() {
//    SportTestTheme(darkTheme = false) {
//        MatchCard(viewModel = )
//    }
//}
//
//@Preview
//@Composable
//private fun PreviewDark() {
//    SportTestTheme(darkTheme = true) {
//        MatchCard(v)
//    }
//}