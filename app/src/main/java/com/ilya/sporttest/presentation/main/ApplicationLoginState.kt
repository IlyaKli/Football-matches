package com.ilya.sporttest.presentation.main

sealed class ApplicationLoginState {

    object Login: ApplicationLoginState()

    object Initial: ApplicationLoginState()
}
