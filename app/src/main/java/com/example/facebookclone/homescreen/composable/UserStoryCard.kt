package com.example.facebookclone.homescreen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest.Builder
import com.example.facebookclone.R.string
import com.example.facebookclone.ui.theme.StoryBg
import com.example.facebookclone.ui.theme.StoryBorder

@Composable fun UserStoryCard(
  avatarUrl: String
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
          .data(avatarUrl)
          .crossfade(true)
          .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .fillMaxSize()
          .clip(MaterialTheme.shapes.medium),
      )

      //
      var bgHeight by remember {
        mutableStateOf(0.dp)
      }
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .background(StoryBg)
          .height(bgHeight - 19.dp)
          .align(Alignment.BottomCenter)
      )

      val density =
        LocalDensity.current // we need to density to because we need to convert pixel to dp
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .align(Alignment.BottomCenter)
          .onGloballyPositioned {
            // here convert pixel to dp
            bgHeight = with(density) {
              it.size.height.toDp()
            }
          },
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        Box(
          modifier = Modifier
            .size(36.dp)
            .border(2.dp, MaterialTheme.colors.surface, CircleShape)
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            Rounded.Add,
            contentDescription = stringResource(id = string.add),
            tint = MaterialTheme.colors.surface,
            modifier = Modifier.size(26.dp)
          )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = stringResource(id = string.create_a_story),
          textAlign = TextAlign.Center,
          fontSize = 16.sp,
          modifier = Modifier.padding(horizontal = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
      }
    }
  }
}

@Preview
@Composable
fun PreviewUserStoryCard(
  avatarUrl: String = " "
) {
  // avatarUrl = "https://images.unsplash.com/flagged/photo-1570612861542-284f4c12e75f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"
  UserStoryCard(avatarUrl)
}