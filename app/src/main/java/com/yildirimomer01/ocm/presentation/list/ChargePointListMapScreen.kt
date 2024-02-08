package com.yildirimomer01.ocm.presentation.list

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.yildirimomer01.ocm.R
import com.yildirimomer01.ocm.core.widget.OcmChargePoint
import com.yildirimomer01.ocm.presentation.Screen

@Composable
fun PoiListMapScreen (
    modifier: Modifier = Modifier,
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    onMapLoaded: () -> Unit = {},
    content: @Composable () -> Unit = {},
    mapVisible: Boolean,
    navController: NavController,
    state: ChargePointListScreenState
) {
    if (mapVisible) {
        val uiSettings by remember { mutableStateOf(MapUiSettings(compassEnabled = true)) }
        val mapProperties by remember {
            mutableStateOf(MapProperties(mapType = MapType.NORMAL))
        }

        GoogleMap(modifier = modifier,
            cameraPositionState = cameraPositionState,
            properties = mapProperties,
            uiSettings = uiSettings,
            onMapLoaded = onMapLoaded,
        ) {
            state.poiList.forEach { poi ->
                OcmChargePoint(
                    context = LocalContext.current,
                    position = LatLng(poi.latitude, poi.longitude),
                    title = poi.title,
                    snippet = poi.title,
                    iconResourceId = R.drawable.ic_charging_station,
                    onClick = {
                        navController.navigate(Screen.DetailScreen.route + "/${poi.pointId}")
                        true
                    }
                )
            }
        }
        content()
    }
}