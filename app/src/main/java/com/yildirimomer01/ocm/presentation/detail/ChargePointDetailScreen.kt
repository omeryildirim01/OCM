package com.yildirimomer01.ocm.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.yildirimomer01.ocm.core.widget.AddressDetailsCard
import com.yildirimomer01.ocm.core.widget.PoiErrorScreen
import com.yildirimomer01.ocm.core.widget.PoiLoadingScreen

@Composable
fun ChargePointDetailsScreen(
    viewModel: ChargePointDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.chargePoint?.let { chargePoint ->
            AddressDetailsCard(uiModel = chargePoint)
        }
        PoiErrorScreen(state = state.error.isNotBlank(), error = state.error)
        PoiLoadingScreen(state = state.isLoading)
    }
}

