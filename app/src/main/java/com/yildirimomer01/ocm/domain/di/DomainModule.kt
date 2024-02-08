package com.yildirimomer01.ocm.domain.di

import com.yildirimomer01.ocm.core.util.OCMKeyProvider
import com.yildirimomer01.ocm.domain.repository.OcmRepository
import com.yildirimomer01.ocm.domain.usecase.GetInitialChannelParamsUseCase
import com.yildirimomer01.ocm.domain.usecase.FetchPoiListUseCase
import com.yildirimomer01.ocm.domain.usecase.GetChargePointUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    @Singleton
    fun provideGetPoiListUseCase(repository: OcmRepository): FetchPoiListUseCase {
        return FetchPoiListUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetInitialChannelParamsUseCase(provider: OCMKeyProvider): GetInitialChannelParamsUseCase {
        return GetInitialChannelParamsUseCase(provider)
    }

    @Provides
    @Singleton
    fun provideGetChargePointUseCase(repository: OcmRepository, provider: OCMKeyProvider): GetChargePointUseCase {
        return GetChargePointUseCase(repository, keyProvider = provider)
    }
}