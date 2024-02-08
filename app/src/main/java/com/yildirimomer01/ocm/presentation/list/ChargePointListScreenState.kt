package com.yildirimomer01.ocm.presentation.list

import com.yildirimomer01.ocm.domain.model.ChargePointListItemUiModel

data class ChargePointListScreenState(
    val isLoading: Boolean = false,
    val poiList: List<ChargePointListItemUiModel> = emptyList(),
    val error: String = ""
)
