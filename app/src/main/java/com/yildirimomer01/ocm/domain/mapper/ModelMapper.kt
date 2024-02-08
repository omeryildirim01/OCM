package com.yildirimomer01.ocm.domain.mapper

import com.yildirimomer01.ocm.data.dto.ItemPoi
import com.yildirimomer01.ocm.domain.model.ChargePointDetailUiModel
import com.yildirimomer01.ocm.domain.model.ChargePointListItemUiModel

fun ItemPoi.toChargePointListItemUiModel(): ChargePointListItemUiModel {
    return ChargePointListItemUiModel(
        pointId = this.iD,
        latitude = this.addressInfo.latitude,
        longitude = this.addressInfo.longitude,
        title = this.addressInfo.title.orEmpty()
    )
}

fun ItemPoi.toChargePointDetailUiModel(): ChargePointDetailUiModel {
    return ChargePointDetailUiModel(
        id = this.iD,
        title = this.addressInfo.title.orEmpty(),
        addressLine1 = this.addressInfo.addressLine1,
        addressLine2 = this.addressInfo.addressLine2.orEmpty(),
        town = this.addressInfo.town.orEmpty(),
        postcode = this.addressInfo.postcode,
        country = this.addressInfo.country.continentCode,
        numberOfChargingPoints = this.numberOfPoints
    )
}