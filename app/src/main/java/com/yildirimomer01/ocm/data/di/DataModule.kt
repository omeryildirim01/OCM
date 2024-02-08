package com.yildirimomer01.ocm.data.di

import android.content.Context
import com.yildirimomer01.ocm.core.common.Constants.BASE_URL
import com.yildirimomer01.ocm.core.util.OCMKeyProvider
import com.yildirimomer01.ocm.data.network.OcmApi
import com.yildirimomer01.ocm.data.repository.OcmRepositoryImpl
import com.yildirimomer01.ocm.domain.repository.OcmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun provideApi(): OcmApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(OcmApi::class.java)
    }

    @Provides
    @Singleton
    fun provideImageRepo(api: OcmApi): OcmRepository {
        return OcmRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideOCMKeyProvider(@ApplicationContext appContext: Context): OCMKeyProvider {
        return OCMKeyProvider(appContext)
    }
}