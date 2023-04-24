package com.example.facebookclone.homescreen.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebookclone.data.Post

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenContents(
  posts: List<Post>,
  avatarUrl: String,
  navigateToUserProfile: () -> Unit,
  onTextChange: (String) -> Unit,
  onSendClick: () -> Unit
) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colors.background)
  ) {

    // putting one after other
    LazyColumn(
      contentPadding = PaddingValues(bottom = 40.dp)
    ) {
      item {
        TopAppBar()
      }
      stickyHeader {
        TopBar()
      }
      item {
        Spacer(modifier = Modifier.height(8.dp))
      }
      item {
        StatusUpdateBar(
          avatarUrl = avatarUrl,
          navigateToUserProfile = navigateToUserProfile,
          onTextChange = onTextChange,
          onSendClick = onSendClick
        )
      }
      item {
        GoLiveSection()
      }

      item {
        Spacer(modifier = Modifier.height(8.dp))
      }
      item {
        StoriesSections(avatarUrl)
      }
      item {
        Spacer(modifier = Modifier.height(8.dp))
      }
      items(posts) { post ->
        Spacer(modifier = Modifier.height(8.dp))
        PostCard(post)
        Spacer(modifier = Modifier.height(8.dp))
      }
    }
  }
}

@Preview
@Composable
fun PreviewHomeScreenContents(
  posts: List<Post> = emptyList(),
  navigateToUserProfile: () -> Unit = {},
  avatarUrl: String = "https://images.unsplash.com/photo-1612983881270-6de7d8862f11?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80\"",
  onTextChange:(String)-> Unit = { },
  onSendClick:() -> Unit = { }
) {
  HomeScreenContents(posts,avatarUrl,navigateToUserProfile, onTextChange, onSendClick)
}