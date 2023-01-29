package com.ilya.sporttest.data.di

import com.ilya.sporttest.data.network.ApiFactory
import com.ilya.sporttest.data.network.ApiService
import com.ilya.sporttest.data.repository.SportAppRepositoryImpl
import com.ilya.sporttest.domain.repository.SportAppRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindMovieRepository(impl: SportAppRepositoryImpl): SportAppRepository

    companion object {

//        @ApplicationScope
//        @Provides
//        fun provideMoviesDao(application: Application): SportAppDao {
//            return SportAppDatabase.getInstance(application).sportAppDao()
//        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}