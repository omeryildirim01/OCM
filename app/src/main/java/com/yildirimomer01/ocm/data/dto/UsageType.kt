package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class UsageType(
    @SerializedName("description") val description: String?,
    @SerializedName("ID") val iD: Int,
    @SerializedName("IsAccessKeyRequired") val isAccessKeyRequired: Boolean,
    @SerializedName("IsMembershipRequired") val isMembershipRequired: Boolean,
    @SerializedName("IsPayAtLocation") val isPayAtLocation: Boolean,
    @SerializedName("Title") val title: String?
)