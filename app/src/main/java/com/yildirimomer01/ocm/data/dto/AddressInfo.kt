package com.yildirimomer01.ocm.data.dto


import com.google.gson.annotations.SerializedName

data class AddressInfo(
    @SerializedName("AccessComments") val accessComments: String?,
    @SerializedName("AddressLine1") val addressLine1: String,
    @SerializedName("AddressLine2") val addressLine2: String?,
    @SerializedName("ContactEmail") val contactEmail: String?,
    @SerializedName("ContactTelephone1") val contactTelephone1: Any?,
    @SerializedName("ContactTelephone2") val contactTelephone2: Any?,
    @SerializedName("Country") val country: Country,
    @SerializedName("CountryID") val countryID: Int,
    @SerializedName("description") val description: String?,
    @SerializedName("Distance") val distance: Any?,
    @SerializedName("DistanceUnit") val distanceUnit: Int,
    @SerializedName("ID") val iD: Int,
    @SerializedName("Latitude") val latitude: Double,
    @SerializedName("Longitude") val longitude: Double,
    @SerializedName("Postcode") val postcode: String,
    @SerializedName("RelatedURL") val relatedURL: String?,
    @SerializedName("StateOrProvince") val stateOrProvince: String,
    @SerializedName("Title") val title: String?,
    @SerializedName("Town") val town: String
)

