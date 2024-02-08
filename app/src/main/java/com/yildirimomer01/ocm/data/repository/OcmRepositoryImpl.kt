package com.yildirimomer01.ocm.data.repository

import com.yildirimomer01.ocm.data.dto.ItemPoi
import com.yildirimomer01.ocm.data.network.OcmApi
import com.yildirimomer01.ocm.domain.repository.OcmRepository
import javax.inject.Inject

/**
 * Repository implementation to perform api operations
 */
class OcmRepositoryImpl @Inject constructor(private val api: OcmApi) : OcmRepository {

    override suspend fun getPoiList(
        key: String,
        output: String?,
        distanceUnit: String?,
        distance: Int?,
        latitude: Double?,
        longitude: Double?
    ): List<ItemPoi> {
        return api.getPoiList(
            key = key,
            output = output,
            distanceUnit = distanceUnit,
            distance = distance,
            latitude = latitude,
            longitude = longitude
        )
    }

    override suspend fun getPoiDetail(key: String, chargePointId: Long): ItemPoi? {
        return api.getPoiDetail(key, chargePointId).firstOrNull()
    }
}