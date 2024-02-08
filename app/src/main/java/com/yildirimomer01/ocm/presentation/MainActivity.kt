package com.yildirimomer01.ocm.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yildirimomer01.ocm.presentation.detail.ChargePointDetailsScreen
import com.yildirimomer01.ocm.presentation.list.ChargePointListScreen
import com.yildirimomer01.ocm.ui.theme.OCMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OCMTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ListScreen.route
                    ) {
                        composable(route = Screen.ListScreen.route) {
                            ChargePointListScreen(navController = navController)
                        }
                        composable(route = Screen.DetailScreen.route + "/{poiId}") {
                            ChargePointDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}
