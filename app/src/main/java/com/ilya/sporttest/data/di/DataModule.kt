package com.ilya.sporttest.data.di

import com.ilya.sporttest.data.network.ApiService
import com.ilya.sporttest.data.repository.SportAppRepositoryImpl
import com.ilya.sporttest.domain.repository.SportAppRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        fun provideOkHttpClient() =
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

        @Provides
        @ApplicationScope
        fun provideApiFactory(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        @Provides
        @ApplicationScope
        fun provideApiService(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java)

        private const val BASE_URL = "https://api.soccersapi.com/v2.2/"
    }
}