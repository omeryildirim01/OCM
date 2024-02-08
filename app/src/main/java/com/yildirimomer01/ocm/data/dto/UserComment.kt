package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class UserComment(
    @SerializedName("ChargePointID") val chargePointID: Int,
    @SerializedName("CheckinStatusType") val checkinStatusType: CheckinStatusType,
    @SerializedName("CheckinStatusTypeID") val checkinStatusTypeID: Int,
    @SerializedName("Comment") val comment: String,
    @SerializedName("CommentType") val commentType: CommentType,
    @SerializedName("CommentTypeID") val commentTypeID: Int,
    @SerializedName("DateCreated") val dateCreated: String,
    @SerializedName("ID") val iD: String,
    @SerializedName("RelatedURL") val relatedURL: String,
    @SerializedName("User") val user: User,
    @SerializedName("UserName") val userName: String
)