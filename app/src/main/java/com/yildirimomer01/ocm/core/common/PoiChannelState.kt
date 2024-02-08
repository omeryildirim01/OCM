package com.yildirimomer01.ocm.core.common

sealed interface PoiChannelState {
    object Enabled : PoiChannelState
    object Disabled : PoiChannelState
}