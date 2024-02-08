package com.yildirimomer01.ocm.domain.usecase

import com.yildirimomer01.ocm.core.common.Resource
import com.yildirimomer01.ocm.core.util.OCMKeyProvider
import com.yildirimomer01.ocm.domain.mapper.toChargePointDetailUiModel
import com.yildirimomer01.ocm.domain.model.ChargePointDetailUiModel
import com.yildirimomer01.ocm.domain.repository.OcmRepository
import javax.inject.Inject

/**
 * the use-case for that can be used to get charge point
 */
class GetChargePointUseCase @Inject constructor(
    private val repository: OcmRepository,
    private val keyProvider: OCMKeyProvider
) {

    suspend fun invoke(chargePointId: Long): Resource<ChargePointDetailUiModel?> {
        return try {
            Resource.Success(
                repository.getPoiDetail(keyProvider.provideOcmKey(), chargePointId)?.toChargePointDetailUiModel()
            )
        } catch (e: Throwable) {
            Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred")
        }
    }
}