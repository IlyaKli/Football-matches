package com.ilya.sporttest.presentation.main

sealed class ApplicationLoginState {

    object Login: ApplicationLoginState()

    object Web: ApplicationLoginState()

    object Initial: ApplicationLoginState()
}
