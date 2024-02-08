package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class ItemPoi(
    @SerializedName("AddressInfo") val addressInfo: AddressInfo,
    @SerializedName("Connections") val connections: List<Connection>,
    @SerializedName("DataProvider") val dataProvider: DataProvider,
    @SerializedName("DataProviderID") val dataProviderID: Int,
    @SerializedName("DataProvidersReference") val dataProvidersReference: String?,
    @SerializedName("DataQualityLevel") val dataQualityLevel: Int,
    @SerializedName("DateCreated") val dateCreated: String,
    @SerializedName("DateLastConfirmed") val dateLastConfirmed: String?,
    @SerializedName("DateLastStatusUpdate") val dateLastStatusUpdate: String,
    @SerializedName("DateLastVerified") val dateLastVerified: String,
    @SerializedName("DatePlanned") val datePlanned: String?,
    @SerializedName("GeneralComments") val generalComments: String?,
    @SerializedName("ID") val iD: Long,
    @SerializedName("IsRecentlyVerified") val isRecentlyVerified: Boolean,
    @SerializedName("MediaItems") val mediaItems: List<MediaItem>?,
    @SerializedName("MetadataValues") val metadataValues: List<Any>?,
    @SerializedName("NumberOfPoints") val numberOfPoints: Int,
    @SerializedName("OperatorID") val operatorID: Int,
    @SerializedName("OperatorInfo") val operatorInfo: OperatorInfo,
    @SerializedName("OperatorsReference") val operatorsReference: String?,
    @SerializedName("ParentChargePointID") val parentChargePointID: Int?,
    @SerializedName("PercentageSimilarity") val percentageSimilarity: Any?,
    @SerializedName("StatusType") val statusType: StatusTypeX,
    @SerializedName("StatusTypeID") val statusTypeID: Int,
    @SerializedName("SubmissionStatus") val submissionStatus: SubmissionStatus,
    @SerializedName("SubmissionStatusTypeID") val submissionStatusTypeID: Int,
    @SerializedName("UUID") val uUID: String,
    @SerializedName("UsageCost") val usageCost: String?,
    @SerializedName("UsageType") val usageType: UsageType,
    @SerializedName("UsageTypeID") val usageTypeID: Int,
    @SerializedName("UserComments") val userComments: List<UserComment>?
)