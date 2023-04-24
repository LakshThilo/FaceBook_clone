package com.example.facebookclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.facebookclone.homescreen.HomeScreen
import com.example.facebookclone.singin.SignInScreen
import com.example.facebookclone.ui.theme.FacebookCloneTheme
import com.example.facebookclone.userprofile.UserProfileScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {

      FacebookCloneTheme {
        // adding transparent app bar
        TransparentSystemBars()

        val navController = rememberNavController()

        val homeRoute = "home"
        val signInRoute = "signin"
        val userProfileRoute = "user_profile"
        NavHost(navController = navController, startDestination = homeRoute) {

          composable(homeRoute) {
            HomeScreen(
              navigateToSignIn = {
                navController.navigate(signInRoute) {
                  popUpTo(homeRoute) {
                    inclusive = true
                  }
                }
              },
              navigateToUserProfile = {
                navController.navigate(userProfileRoute){
                  popUpTo(homeRoute) {
                    inclusive = true
                  }
                }
              }
            )
          }

          composable(signInRoute) {
            SignInScreen(
              navigateToHome = {
                navController.navigate(homeRoute) {
                  popUpTo(homeRoute) {
                    inclusive = true
                  }
                }
              }
            )
          }

          composable(userProfileRoute) {
            UserProfileScreen(
              navigateToHome = {
              navController.navigate(homeRoute) {
                popUpTo(homeRoute) {
                  inclusive = true
                }
              }
            }
            )
          }
        }
      }
    }
  }
}

@Composable
fun TransparentSystemBars() {
// Remember a SystemUiController
  val systemUiController = rememberSystemUiController()
  val useDarkIcons = !isSystemInDarkTheme()

  DisposableEffect(systemUiController, useDarkIcons) {
    // Update all of the system bar colors to be transparent, and use
    // dark icons if we're in light theme
    systemUiController.setSystemBarsColor(
      color = Color.Transparent,
      darkIcons = useDarkIcons
    )

    // setStatusBarColor() and setNavigationBarColor() also exist
    onDispose {}
  }
}
