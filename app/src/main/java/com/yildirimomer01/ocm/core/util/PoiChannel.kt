package com.yildirimomer01.ocm.core.util

import com.yildirimomer01.ocm.core.common.Resource
import com.yildirimomer01.ocm.domain.model.ChargePointListItemUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

interface PoiChannel {
    @ExperimentalCoroutinesApi
    fun fetch(
        params: PoiListChannelParams
    ): Flow<Resource<List<ChargePointListItemUiModel>>>
}

data class PoiListChannelParams(
    val key: String,
    val output: String,
    val distanceUnit: String,
    val distance: Int,
    val latitude: Double,
    val longitude: Double,
    val durationTime: Long,
    val isCancelled: () -> Boolean,
    val dispatcher: CoroutineDispatcher
)