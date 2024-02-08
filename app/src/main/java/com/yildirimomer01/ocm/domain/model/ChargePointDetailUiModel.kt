package com.yildirimomer01.ocm.domain.model


data class ChargePointDetailUiModel(
    val id: Long,
    val title: String,
    val postcode: String,
    val country: String,
    val addressLine1:String,
    val addressLine2:String,
    val town: String,
    val numberOfChargingPoints: Int
)

