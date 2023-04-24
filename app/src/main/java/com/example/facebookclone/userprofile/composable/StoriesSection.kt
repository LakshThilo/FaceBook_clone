package com.example.facebookclone.userprofile.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest.Builder
import com.example.facebookclone.homescreen.composable.Scrim
import com.example.facebookclone.ui.theme.StoryBorder

@Preview
@Composable
fun StoriesSection() {
  Surface() {
    LazyRow(
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(start = 16.dp, top = 8.dp, bottom = 16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      item {
        AddNewStory()
      }
      item {
        PreviousStores()
      }
    }
  }
}

@Composable
private fun AddNewStory() {
  Column(modifier = Modifier.fillMaxSize()) {
    Card(
      modifier = Modifier
        .size(76.dp, 136.dp)
        .border(2.dp, StoryBorder, MaterialTheme.shapes.medium),
    ) {
      Box(
        Modifier
          .fillMaxSize()
          .background(StoryBorder),
        contentAlignment = Alignment.Center
      ) {
        Icon(Rounded.Add, contentDescription = "")
      }
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.CenterHorizontally),
    ) {
      Text(text = "New", textAlign = TextAlign.Center)
    }
  }
}

@Composable
fun PreviousStores() {
  Column(modifier = Modifier.fillMaxSize()) {
    Card(
      modifier = Modifier
        .size(76.dp, 136.dp),
    ) {
      Box(
        Modifier
          .fillMaxSize()
          .background(StoryBorder),
        contentAlignment = Alignment.Center
      ) {
        val avatarUrl =
          "https://images.unsplash.com/photo-1628157588553-5eeea00af15c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1160&q=80"
        AsyncImage(
          model = Builder(LocalContext.current)
            .data(avatarUrl)
            .crossfade(true)
            .build(),
          contentDescription = null,
          contentScale = ContentScale.Crop,
          modifier = Modifier
            .fillMaxSize()
            .clip(MaterialTheme.shapes.medium),
        )
        Scrim(
          modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .align(Alignment.BottomStart)
        )

        Row(
          modifier = Modifier
            .padding(start = 4.dp, bottom = 4.dp)
            .align(Alignment.BottomStart),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(Rounded.Add, contentDescription = "", modifier = Modifier.size(14.dp), tint = Color.White)
          Spacer(modifier = Modifier.width(2.dp))
          Text(
            text = "2",
            color = Color.White,
            fontSize = 12.sp,
          )
        }
      }
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.CenterHorizontally),
    ) {
      Text(text = "Features", textAlign = TextAlign.Center)
    }
  }
}

