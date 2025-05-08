package com.snakegame.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationScreens() {

    @Serializable
    data object SplashScreen : NavigationScreens()

    @Serializable
    data object WelcomeScreen : NavigationScreens()

    @Serializable
    data object GameScreen : NavigationScreens()

    @Serializable
    data object ResultScreen : NavigationScreens()

    @Serializable
    data object SettingsScreen : NavigationScreens()
}