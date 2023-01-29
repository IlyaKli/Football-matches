package com.ilya.sporttest.data.di

import androidx.lifecycle.ViewModel
import com.ilya.sporttest.presentation.main.MatchesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MatchesViewModel::class)
    fun bindMainViewModel(viewModel: MatchesViewModel): ViewModel
}