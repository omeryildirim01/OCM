package com.yildirimomer01.ocm.presentation.list

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.rememberCameraPositionState
import com.yildirimomer01.ocm.core.common.Constants.DEFAULT_CAMERA_POSITION
import com.yildirimomer01.ocm.core.common.Constants.DEFAULT_POSITION
import com.yildirimomer01.ocm.core.widget.PoiErrorScreen
import com.yildirimomer01.ocm.core.widget.PoiLoadingScreen

@Composable
fun ChargePointListScreen(
    navController: NavController,
    viewModel: ChargePointListViewModel = hiltViewModel()
) {
    val defaultCameraPosition = CameraPosition.fromLatLngZoom(DEFAULT_POSITION, DEFAULT_CAMERA_POSITION)
    val state: ChargePointListScreenState by viewModel.viewState.collectAsState()
    val mapVisible by remember { mutableStateOf(true) }

    val cameraPositionState = rememberCameraPositionState {
        position = defaultCameraPosition
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (state.poiList.isNotEmpty()) {
            Box(Modifier.fillMaxSize()) {
                PoiListMapScreen(
                    modifier = Modifier.matchParentSize(),
                    cameraPositionState = cameraPositionState,
                    onMapLoaded = {},
                    mapVisible = mapVisible,
                    navController = navController,
                    state = state
                )
            }
        }
        PoiErrorScreen(state = state.error.isNotBlank(), error = state.error)
        PoiLoadingScreen(state = state.isLoading)
    }
}