package com.ilya.sporttest.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ilya.sporttest.presentation.web.WebScreen
import com.ilya.sporttest.ui.theme.SportTestTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportTestTheme {
                val viewModel: MatchesViewModel = viewModel()
                val loginState = viewModel.mainScreenState.observeAsState(ApplicationLoginState.Initial)


                when(loginState.value) {
                    is ApplicationLoginState.Login -> {
                        MainScreen {
                            viewModel.openWebScreen()
                        }
                    }
                    is ApplicationLoginState.Web -> {
                        WebScreen() {
                            viewModel.initialLoadMatches()
                        }
                    }
                    else -> {
                        SplashScreen()
                        viewModel.initialLoadMatches()
                    }
                }
            }
        }
    }
}