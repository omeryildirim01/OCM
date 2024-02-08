package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class MediaItem(
    @SerializedName("ChargePointID") val chargePointID: String,
    @SerializedName("Comment") val comment: String,
    @SerializedName("DateCreated") val dateCreated: String,
    @SerializedName("ID") val iD: String,
    @SerializedName("IsEnabled") val isEnabled: Boolean,
    @SerializedName("IsExternalResource") val isExternalResource: Boolean,
    @SerializedName("IsFeaturedItem") val isFeaturedItem: Boolean,
    @SerializedName("IsVideo") val isVideo: Boolean,
    @SerializedName("ItemThumbnailURL") val itemThumbnailURL: String,
    @SerializedName("ItemURL") val itemURL: String,
    @SerializedName("User") val user: User
)