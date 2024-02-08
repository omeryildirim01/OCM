package com.yildirimomer01.ocm.domain.usecase

import com.yildirimomer01.ocm.core.common.Constants
import com.yildirimomer01.ocm.core.util.OCMKeyProvider
import com.yildirimomer01.ocm.core.util.PoiListChannelParams
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetInitialChannelParamsUseCase @Inject constructor(private val keyProvider: OCMKeyProvider) {

    operator fun invoke(isCancelled: () -> Boolean): PoiListChannelParams {
        return runCatching {
            PoiListChannelParams(
                key = keyProvider.provideOcmKey(),
                output = Constants.OUTPUT_TYPE,
                distanceUnit = Constants.DISTANCE_TYPE,
                distance = Constants.DISTANCE,
                latitude = Constants.INIT_LAT,
                longitude = Constants.INIT_LONG,
                durationTime = Constants.DURATION,
                isCancelled = isCancelled,
                dispatcher = Dispatchers.IO
            )
        }.getOrDefault(
            PoiListChannelParams(
                key = "",
                output = Constants.OUTPUT_TYPE,
                distanceUnit = Constants.DISTANCE_TYPE,
                distance = Constants.DISTANCE,
                latitude = Constants.INIT_LAT,
                longitude = Constants.INIT_LONG,
                durationTime = Constants.DURATION,
                isCancelled = isCancelled,
                dispatcher = Dispatchers.IO
            )
        )
    }
}