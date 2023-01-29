package com.ilya.sporttest.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ilya.sporttest.domain.model.Match

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MatchCard(
    match: Match,
    onMatchCardClickListener: (matchId: Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 2.dp,
        backgroundColor = MaterialTheme.colors.background,
        onClick = {
            onMatchCardClickListener(match.id)
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = match.league.name,
                color = MaterialTheme.colors.onPrimary
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    AsyncImage(
                        model = match.teams.home.image,
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .padding(bottom = 8.dp)
                    )
                    Text(
                        text = match.teams.home.name,
                        color = MaterialTheme.colors.onPrimary
                    )
                }

                Text(
                    text = "${match.scores.homeScore} : ${match.scores.awayScore}",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.wrapContentHeight()
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    AsyncImage(
                        model = match.teams.away.image,
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .padding(bottom = 8.dp)
                    )
                    Text(
                        text = match.teams.away.name,
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
//        Test()
//    }
//}
//
//@Preview
//@Composable
//private fun PreviewDark() {
//    SportTestTheme(darkTheme = true) {
//        Test()
//    }
//}
//
//
//@Composable
//fun Test() {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        elevation = 2.dp,
//        backgroundColor = MaterialTheme.colors.background
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(
//                text = "match.league.name",
//                color = MaterialTheme.colors.onPrimary
//            )
//            Row(
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(10.dp)
//                ) {
//                    Image(
//                        imageVector = Icons.Filled.AccountBox,
//                        contentDescription = null,
//                        modifier = Modifier.size(80.dp)
//                    )
//                    Text(
//                        text = "match.name",
//                        color = MaterialTheme.colors.onPrimary
//                    )
//                }
//
//                Text(
//                    text = "1 : 1",
//                    textAlign = TextAlign.Center,
//                    color = MaterialTheme.colors.onPrimary,
//                    modifier = Modifier
//                        .weight(0.5f)
//                )
//
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(10.dp)
//                ) {
//                    Image(
//                        imageVector = Icons.Filled.AccountBox,
//                        contentDescription = null,
//                        modifier = Modifier.size(80.dp)
//                    )
//                    Text(
//                        text = "match.teamsasdasd",
//                        color = MaterialTheme.colors.onPrimary
//                    )
//                }
//            }
//        }
//    }
//}