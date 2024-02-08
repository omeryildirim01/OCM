package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class OperatorInfo(
    @SerializedName("AddressInfo") val addressInfo: AddressInfo?,
    @SerializedName("BookingURL") val bookingURL: String?,
    @SerializedName("Comments") val comments: Any?,
    @SerializedName("ContactEmail") val contactEmail: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("FaultReportEmail") val faultReportEmail: String?,
    @SerializedName("ID") val iD: Int,
    @SerializedName("IsPrivateIndividual") val isPrivateIndividual: Boolean,
    @SerializedName("IsRestrictedEdit") val isRestrictedEdit: Boolean,
    @SerializedName("PhonePrimaryContact") val phonePrimaryContact: Any?,
    @SerializedName("PhoneSecondaryContact") val phoneSecondaryContact: Any?,
    @SerializedName("Title") val title: String?,
    @SerializedName("WebsiteURL") val websiteURL: String
)