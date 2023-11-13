package com.example.dogsphotos.presentation.nvgraph

sealed class Route(
    val route:String
){
    object OnBoardingScreen:Route(route = "onBoardingScreen")
    object AppStartNavigation : Route(route = "appStartNavigation")
    object PhotosNavigator : Route(route="photosNavigation")
    object PhotosNavigatorScreen : Route(route="photosNavigationScreen")

    object HomeScreen : Route(route = "homeScreen")

    object SearchScreen : Route(route = "searchScreen")

    object BookmarkScreen : Route(route = "bookMarkScreen")

    object DetailsScreen : Route(route = "detailsScreen")
}
