package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class ConnectionType(
    @SerializedName("description") val description: String?,
    @SerializedName("FormalName") val formalName: String,
    @SerializedName("ID") val iD: Int,
    @SerializedName("IsDiscontinued") val isDiscontinued: Boolean,
    @SerializedName("IsObsolete") val isObsolete: Boolean,
    @SerializedName("Title") val title: String?
)