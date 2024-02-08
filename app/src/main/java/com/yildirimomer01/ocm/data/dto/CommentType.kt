package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class CommentType(
    @SerializedName("ID") val iD: Int,
    @SerializedName("Title") val title: String
)