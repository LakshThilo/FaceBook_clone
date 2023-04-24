package com.example.facebookclone.homescreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.facebookclone.homescreen.HomeScreenState.Loaded
import com.example.facebookclone.homescreen.HomeScreenState.Loading
import com.example.facebookclone.homescreen.HomeScreenState.SignInRequired
import com.example.facebookclone.homescreen.composable.HomeScreenContents
import com.example.facebookclone.homescreen.composable.LoadingScreen

@Composable
fun HomeScreen(
  navigateToUserProfile: () -> Unit,
  navigateToSignIn: () -> Unit
) {

  val viewModel = viewModel<HomeViewModel>()
  val state by viewModel.state.collectAsState()
  when (state) {
    is Loaded -> {
      val loaded = state as HomeScreenState.Loaded
      HomeScreenContents(
        posts = loaded.posts,
        avatarUrl = loaded.avatarUrl,
        navigateToUserProfile = navigateToUserProfile,
        onTextChange = {
          viewModel.onTextChange(it)
        },
        onSendClick = {
          viewModel.onSendClick()
        }
      )
    }

    Loading -> LoadingScreen()

    SignInRequired -> LaunchedEffect(Unit) {
      navigateToSignIn()
    }
    // reason is to use LaunchedEffect  is if we call navigateToSignIn() without this this function can call many time and lead to lots of side effects/bugs
  }
}


@Preview
@Composable
fun PreviewHomeScreen(
  navigateToSignIn: () -> Unit = {},
  navigateToUserProfile: () -> Unit = {}
) {
  HomeScreen(navigateToSignIn,navigateToUserProfile)
}
