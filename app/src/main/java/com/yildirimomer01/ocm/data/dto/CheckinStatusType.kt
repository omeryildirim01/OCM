package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class CheckinStatusType(
    @SerializedName("ID") val iD: Int,
    @SerializedName("IsAutomatedCheckin") val isAutomatedCheckin: Boolean,
    @SerializedName("IsPositive") val isPositive: Boolean,
    @SerializedName("Title") val title: String
)