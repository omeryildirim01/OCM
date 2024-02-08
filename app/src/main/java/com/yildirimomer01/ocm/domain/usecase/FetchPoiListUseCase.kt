package com.yildirimomer01.ocm.domain.usecase

import android.util.Log
import com.yildirimomer01.ocm.core.common.Resource
import com.yildirimomer01.ocm.core.util.PoiChannel
import com.yildirimomer01.ocm.core.util.PoiListChannelParams
import com.yildirimomer01.ocm.domain.mapper.toChargePointListItemUiModel
import com.yildirimomer01.ocm.domain.model.ChargePointListItemUiModel
import com.yildirimomer01.ocm.domain.repository.OcmRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * the use-case for the poi channel that can be used for fetching data periodically
 */
class FetchPoiListUseCase @Inject constructor(private val repository: OcmRepository) : PoiChannel {

    @ExperimentalCoroutinesApi
    override fun fetch(params: PoiListChannelParams): Flow<Resource<List<ChargePointListItemUiModel>>> {
        return channelFlow {
            while (!isClosedForSend) {
                if (params.isCancelled.invoke()) {
                    close()
                    return@channelFlow
                }
                runCatching {
                    repository.getPoiList(
                        key = params.key,
                        output = params.output,
                        distanceUnit = params.distanceUnit,
                        distance = params.distance,
                        latitude = params.latitude,
                        longitude = params.longitude,
                    )
                }.onFailure {
                    send(
                        Resource.Error<List<ChargePointListItemUiModel>>(
                            message = it.localizedMessage ?: "An unexpected error occurred"
                        )
                    )
                }.onSuccess {
                    send(Resource.Success(data = it.map { dto -> dto.toChargePointListItemUiModel() }))
                }
                delay(params.durationTime)
                Log.i("-->>>fetching-poi-list", "-duration : ${params.durationTime}")
            }
        }.flowOn(params.dispatcher)
    }
}