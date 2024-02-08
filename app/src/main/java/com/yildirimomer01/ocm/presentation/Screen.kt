package com.yildirimomer01.ocm.presentation

sealed class Screen(val route: String) {
    object ListScreen: Screen("poi_list_screen")
    object DetailScreen: Screen("poi_detail_screen")
}