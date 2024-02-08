package com.yildirimomer01.ocm.core.common

import com.google.android.gms.maps.model.LatLng

object Constants {
    const val BASE_KEY = "com.yildirimomer01.ocm.OCM_SECRET_API_KEY"
    const val BASE_URL = "https://api.openchargemap.io/"
    const val PARAM_POI_ID = "poiId"
    const val OUTPUT_TYPE = "json"
    const val DISTANCE_TYPE = "km"
    const val DISTANCE = 5
    const val INIT_LAT: Double = 52.526
    const val INIT_LONG: Double = 13.415
    const val DURATION: Long = 30_000
    val DEFAULT_POSITION = LatLng(INIT_LAT, INIT_LONG)
    const val DEFAULT_CAMERA_POSITION = 12f
}