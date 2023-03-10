package com.orlandev.travelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.orlandev.travelapp.navigation.NavRoute
import com.orlandev.travelapp.ui.screens.details.DetailScreen
import com.orlandev.travelapp.ui.screens.home.HomeScreen
import com.orlandev.travelapp.ui.theme.TravelAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

              TravelAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavRoute.HomeScreenRoute.route
                    ) {

                        composable(route = NavRoute.HomeScreenRoute.route) {
                            HomeScreen(navController = navController)
                        }

                        composable(
                            route = NavRoute.DetailScreenRoute.route + "/{city}",
                            arguments = listOf(navArgument("city") {})
                        ) {
                            DetailScreen(navController = navController)
                        }

                    }
                }
            }
        }
    }
}

