package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("ContinentCode") val continentCode: String,
    @SerializedName("description") val description: String?,
    @SerializedName("ID") val iD: Int,
    @SerializedName("ISOCode") val iSOCode: String,
    @SerializedName("Title") val title: String?
)