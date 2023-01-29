package com.ilya.sporttest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ilya.sporttest.ApplicationLoginState
import com.ilya.sporttest.ui.theme.MainScreen
import com.ilya.sporttest.ui.theme.MatchCard
import com.ilya.sporttest.ui.theme.SplashScreen
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