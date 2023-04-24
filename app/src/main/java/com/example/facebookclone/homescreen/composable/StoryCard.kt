package com.example.facebookclone.homescreen.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest.Builder
import com.example.facebookclone.data.FriendStory
import com.example.facebookclone.ui.theme.StoryBorder

@Composable
fun StoryCard(
  stories: FriendStory
) {
  Card(
    modifier = Modifier
      .size(100.dp, 190.dp)
      .border(2.dp, StoryBorder, MaterialTheme.shapes.medium),
  ) {
    Box(
      Modifier.fillMaxSize(),
    ) {
      AsyncImage(
        model = Builder(LocalContext.current)
          .data(stories.bgUrl)
          .crossfade(true)
          .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .fillMaxSize()
          .clip(MaterialTheme.shapes.medium),
      )

      AsyncImage(
        model = Builder(LocalContext.current)
          .data(stories.avatarUrl)
          .crossfade(true)
          .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .padding(8.dp)
          .size(40.dp)
          .align(Alignment.TopStart)
          .clip(CircleShape)
          .border(4.dp, MaterialTheme.colors.primary, CircleShape)
      )

      Scrim(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .align(Alignment.BottomStart))

      Text(
        text = stories.friendName,
        color = MaterialTheme.colors.onPrimary,
        modifier = Modifier
          .padding(8.dp)
          .align(Alignment.BottomStart)
      )
    }
  }
}


@Preview
@Composable
fun PreviewStoryCard(
  stories: FriendStory =   FriendStory(
    friendName = "Frank Young",
    avatarUrl = "https://images.unsplash.com/photo-1628157588553-5eeea00af15c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1160&q=80",
    bgUrl = "https://images.unsplash.com/photo-1511145822182-677fa5800671?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1738&q=80"
  ),
) {
  StoryCard(stories)
}