package com.ilya.sporttest.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ilya.sporttest.ui.theme.SportTestTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportTestTheme {
                val viewModel: MatchesViewModel = viewModel()
                val loginState =viewModel.loginState.observeAsState(ApplicationLoginState.Initial)
                viewModel.initialLoadMatches()

                when(loginState.value) {
                    is ApplicationLoginState.Login -> {
                        MainScreen()
                    }
                    else -> {
                        SplashScreen()
                    }
                }
            }
        }
    }
}