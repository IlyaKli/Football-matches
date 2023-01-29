package com.ilya.sporttest.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ilya.sporttest.presentation.di.SportAppApplication
import com.ilya.sporttest.presentation.di.ViewModelFactory
import com.ilya.sporttest.presentation.web.WebScreen
import com.ilya.sporttest.ui.theme.SportTestTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy { (application as SportAppApplication).component }

    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory)[MatchesViewModel::class.java] }


    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            SportTestTheme {
                val loginState = viewModel.mainScreenState.observeAsState(ApplicationLoginState.Initial)


                when(loginState.value) {
                    is ApplicationLoginState.Login -> {
                        MainScreen(viewModel) {
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