package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class SubmissionStatus(
    @SerializedName("description") val description: String?,
    @SerializedName("ID") val iD: Int,
    @SerializedName("IsLive") val isLive: Boolean,
    @SerializedName("Title") val title: String?
)