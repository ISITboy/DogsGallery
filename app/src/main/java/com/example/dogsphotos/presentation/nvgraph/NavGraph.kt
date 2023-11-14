package com.example.dogsphotos.presentation.nvgraph

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.dogsphotos.presentation.home.HomeScreen
import com.example.dogsphotos.presentation.home.HomeViewModel
import com.example.dogsphotos.presentation.onboarding.OnBoardingScreen
import com.example.dogsphotos.presentation.onboarding.OnBoardingViewModel
import com.example.dogsphotos.presentation.photosNavigator.PhotosNavigator

@Composable
fun NavGraph(
    startDestination:String
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination){
        navigation(
            startDestination = Route.OnBoardingScreen.route,
            route = Route.AppStartNavigation.route
        ){
            composable(route = Route.OnBoardingScreen.route){
                val viewModel : OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = viewModel::onEvent)
            }
        }
        navigation(
            startDestination = Route.PhotosNavigatorScreen.route,
            route = Route.PhotosNavigator.route
        ){
            composable(route = Route.PhotosNavigatorScreen.route){
                PhotosNavigator()
            }
        }
    }
}