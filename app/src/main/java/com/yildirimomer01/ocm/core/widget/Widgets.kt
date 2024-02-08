package com.yildirimomer01.ocm.core.widget

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.*
import com.yildirimomer01.ocm.core.util.bitmapDescriptor
import com.yildirimomer01.ocm.domain.model.ChargePointDetailUiModel

@Composable
fun ChargePoint(
    context: Context,
    position: LatLng,
    title: String,
    snippet: String,
    onClick: (Marker) -> Boolean,
    @DrawableRes iconResourceId: Int
) {
    Marker(
        state = MarkerState(position),
        title = title,
        snippet = snippet,
        icon = bitmapDescriptor(context, iconResourceId),
        onClick = onClick
    )
}

@Composable
fun OcmChargePoint(
    context: Context,
    position: LatLng,
    title: String,
    snippet: String,
    onClick: (Marker) -> Boolean,
    @DrawableRes iconResourceId: Int
) {
    MarkerInfoWindowContent(
        state = MarkerState(position),
        title = title,
        draggable = true,
        snippet = snippet,
        onClick = onClick,
        icon = bitmapDescriptor(context, iconResourceId),
    ) {
        Box {
           Column {
               Text(text = title)
               Spacer(modifier = Modifier.height(3.dp))
               Text(text = "Details...")
           }
        }
    }
}


@Composable
fun PoiLoadingScreen(state: Boolean) {
    if (state) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun PoiErrorScreen(state: Boolean, error: String) {
    if (state) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (error.isNotBlank()) {
                Text(
                    text = error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun AddressLine(addressInfo: String) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                append(addressInfo)
            }
        }
    )
}

@Composable
fun AddressDetailsCard(uiModel: ChargePointDetailUiModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .clickable { },
        elevation = 30.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                    ) {
                        append("Address Details")
                    }
                }
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(fontWeight = FontWeight.W600)
                    ) {
                        append("Point ID :")
                    }
                    append("${uiModel.id}")
                }
            )

            Spacer(modifier = Modifier.height(25.dp))
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(fontWeight = FontWeight.W600)
                    ) {
                        append("Number Of Charge Points : ")
                        append("${uiModel.numberOfChargingPoints}")
                    }
                }
            )
            Spacer(modifier = Modifier.height(25.dp))
            AddressLine(addressInfo = uiModel.addressLine1)
            Spacer(modifier = Modifier.height(5.dp))
            AddressLine(addressInfo = uiModel.addressLine2)
            Spacer(modifier = Modifier.height(5.dp))
            AddressLine(addressInfo = uiModel.town)
            Spacer(modifier = Modifier.height(5.dp))
            AddressLine(addressInfo = uiModel.postcode)
            Spacer(modifier = Modifier.height(5.dp))
            AddressLine(addressInfo = uiModel.country)
        }
    }
}