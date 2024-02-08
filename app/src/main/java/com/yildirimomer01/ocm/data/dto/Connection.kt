package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class Connection(
    @SerializedName("Amps") val amps: Int?,
    @SerializedName("Comments") val comments: String?,
    @SerializedName("ConnectionType") val connectionType: ConnectionType,
    @SerializedName("ConnectionTypeID") val connectionTypeID: Int,
    @SerializedName("CurrentType") val currentType: CurrentType,
    @SerializedName("CurrentTypeID") val currentTypeID: Int,
    @SerializedName("ID") val iD: Int,
    @SerializedName("Level") val level: Level,
    @SerializedName("LevelID") val levelID: Int,
    @SerializedName("PowerKW") val powerKW: Double,
    @SerializedName("Quantity") val quantity: Int,
    @SerializedName("Reference") val reference: Any?,
    @SerializedName("StatusType") val statusType: StatusTypeX,
    @SerializedName("StatusTypeID") val statusTypeID: Int,
    @SerializedName("Voltage") val voltage: Int?
)