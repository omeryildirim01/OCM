package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("ID") val iD: Int,
    @SerializedName("ProfileImageURL") val profileImageURL: String,
    @SerializedName("ReputationPoints") val reputationPoints: Int,
    @SerializedName("Username") val username: String
)