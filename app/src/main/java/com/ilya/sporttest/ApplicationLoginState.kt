package com.ilya.sporttest

sealed class ApplicationLoginState {

    object Login: ApplicationLoginState()

    object Initial: ApplicationLoginState()
}
