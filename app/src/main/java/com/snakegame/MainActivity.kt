package com.snakegame

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.snakegame.navigation.NavigationScreens
import com.snakegame.ui.theme.SnakeGameTheme
import com.snakegame.ui.theme.sceeen.GameScreen
import com.snakegame.ui.theme.sceeen.ResultScreen
import com.snakegame.ui.theme.sceeen.SplashScreenScreen
import com.snakegame.ui.theme.sceeen.WelcomeScreenScreen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            false
        }

        enableEdgeToEdge()
        setContent {

            SnakeGameTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = NavigationScreens.SplashScreen
                    ) {
                        composable<NavigationScreens.SplashScreen>(
                            enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left) },
                            exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left) },
                            popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right) },
                            popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right) }
                        ) {
                            SplashScreenScreen(
                                paddingValues = innerPadding,
                                navigate = {
                                    navController.navigate(NavigationScreens.WelcomeScreen) {
                                        popUpTo(NavigationScreens.SplashScreen) { inclusive = true }
                                    }
                                })
                        }
                        composable<NavigationScreens.WelcomeScreen>(
                            enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left) },
                            exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left) },
                            popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right) },
                            popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right) }
                        ) {
                            WelcomeScreenScreen(
                                paddingValues = innerPadding,
                                onStartClick = {
                                    navController.navigate(NavigationScreens.GameScreen)
                                }
                                 /* onExitClick = {
                                      (context as? Activity)?.finish()
                                }*/
                            )
                        }
                        composable<NavigationScreens.GameScreen>(
                            enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left) },
                            exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left) },
                            popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right) },
                            popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right) }
                        ) {
                            GameScreen(
                                paddingValues = innerPadding
                            )
                        }
                        composable<NavigationScreens.ResultScreen>(
                            enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left) },
                            exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left) },
                            popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right) },
                            popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right) }
                        ) {
                            ResultScreen(
                                paddingValues = innerPadding
                            )
                        }
                    }

                }

            }
        }
    }
}

