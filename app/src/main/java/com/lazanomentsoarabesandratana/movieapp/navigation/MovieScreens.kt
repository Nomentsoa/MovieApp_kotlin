package com.lazanomentsoarabesandratana.movieapp.navigation

enum class MovieScreens {
    HomeScreen,
    DetailsScreen;
    companion object {
        fun formRoute(route: String?): MovieScreens
            = when(route?.substringBefore("/")){
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not ")
            }
    }
}