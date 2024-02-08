package com.yildirimomer01.ocm.presentation.detail

import com.yildirimomer01.ocm.domain.model.ChargePointDetailUiModel


data class ChargePointDetailScreenState(
    val isLoading: Boolean = false,
    val chargePoint: ChargePointDetailUiModel? = null,
    val error: String = ""
)