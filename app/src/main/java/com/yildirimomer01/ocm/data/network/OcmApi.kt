package com.yildirimomer01.ocm.data.network

import com.yildirimomer01.ocm.data.dto.ItemPoi
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  OCM Api contains all endpoints
 */
interface OcmApi {

    @GET("v3/poi/")
    suspend fun getPoiList(
        @Query("key") key: String,
        @Query("output") output: String? = null,
        @Query("distanceunit") distanceUnit: String? = null,
        @Query("distance") distance: Int? = null,
        @Query("latitude") latitude: Double? = null,
        @Query("longitude") longitude: Double? = null
    ): List<ItemPoi>

    @GET("v3/poi/")
    suspend fun getPoiDetail(
        @Query("key") key: String,
        @Query("chargepointid") chargePointId: Long,
    ): List<ItemPoi>
}