package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class Level(
    @SerializedName("Comments") val comments: String,
    @SerializedName("description") val description: String?,
    @SerializedName("ID") val iD: Int,
    @SerializedName("IsFastChargeCapable") val isFastChargeCapable: Boolean,
    @SerializedName("Title") val title: String?
)