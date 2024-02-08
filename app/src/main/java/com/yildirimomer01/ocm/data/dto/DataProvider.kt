package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class DataProvider(
    @SerializedName("Comments") val comments: String?,
    @SerializedName("DataProviderStatusType") val dataProviderStatusType: DataProviderStatusType,
    @SerializedName("DateLastImported") val dateLastImported: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("ID") val iD: Int,
    @SerializedName("IsApprovedImport") val isApprovedImport: Boolean,
    @SerializedName("IsOpenDataLicensed") val isOpenDataLicensed: Boolean,
    @SerializedName("IsRestrictedEdit") val isRestrictedEdit: Boolean,
    @SerializedName("License") val license: String,
    @SerializedName("Title") val title: String?,
    @SerializedName("WebsiteURL") val websiteURL: String
)