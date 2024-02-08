package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class StatusTypeX(
    @SerializedName("description") val description: String?,
    @SerializedName("ID") val iD: Int,
    @SerializedName("IsOperational") val isOperational: Boolean,
    @SerializedName("IsUserSelectable") val isUserSelectable: Boolean,
    @SerializedName("Title") val title: String?
)