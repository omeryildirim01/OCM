package com.yildirimomer01.ocm.domain.repository

import com.yildirimomer01.ocm.core.common.Constants.OUTPUT_TYPE
import com.yildirimomer01.ocm.data.dto.ItemPoi

interface OcmRepository {
    suspend fun getPoiList(
        key: String,
        output: String? = OUTPUT_TYPE,
        distanceUnit: String? = null,
        distance: Int? = null,
        latitude: Double? = null,
        longitude: Double? = null
    ): List<ItemPoi>

    suspend fun getPoiDetail(
        key: String,
        chargePointId: Long
    ): ItemPoi?
}
