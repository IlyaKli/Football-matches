package com.ilya.sporttest.presentation.matchinfo

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ilya.sporttest.R
import com.ilya.sporttest.domain.model.Match

@Composable
fun MatchInfoScreen(
    match: Match,
    onBackPressed: () -> Unit
) {

    BackHandler {
        onBackPressed()
    }
        Box(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primary)
                .padding(top = 10.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(8.dp)
            ) {
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
                Text(
                    text = stringResource(R.string.match_status_text),
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Text(
                    text = match.statusName,
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = stringResource(R.string.liga_title_text),
                    fontSize = 30.sp,
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.liga_name_text),
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .weight(1f)
                    )
                    Text(
                        text = match.league.name,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .weight(1f)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.country_liga_text),
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .weight(1f)
                    )
                    AsyncImage(
                        model = match.league.countryFlagImageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .weight(1f)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.group_text),
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .weight(1f)
                    )
                    Text(
                        text = match.groupName,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .weight(1f)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.week_text),
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .weight(1f)
                    )
                    Text(
                        text = match.week,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .weight(1f)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.start_time_match),
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .weight(1f)
                    )
                    Text(
                        text = "${match.time.time} ${match.time.timezone}",
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .weight(1f)
                    )
                }
                Text(
                    text = stringResource(R.string.weather_text),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.weather_description_text),
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .weight(1f)
                    )
                    Text(
                        text = match.weather?.description ?: "????????????????????",
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .weight(1f)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.temperature_text),
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .weight(1f)
                    )
                    Text(
                        text = match.weather?.temperature?.celsius ?: "????????????????????",
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .weight(1f)
                    )
                }
            }
        }
//    }
}


//@Composable
//private fun PreviewLight() {
//    SportTestTheme(darkTheme = false) {
//        MatchInfoScreen()
//    }
//}
//
//@Preview
//@Composable
//private fun PreviewDark() {
//    SportTestTheme(darkTheme = true) {
//        MatchInfoScreen()
//    }
//}