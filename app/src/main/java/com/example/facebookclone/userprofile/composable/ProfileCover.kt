package com.example.facebookclone.userprofile.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material.icons.rounded.MoreHoriz
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest.Builder
import com.example.facebookclone.R.drawable
import com.example.facebookclone.R.string
import com.example.facebookclone.ui.theme.BrandBlue
import com.example.facebookclone.ui.theme.PrimaryBg
import com.example.facebookclone.userprofile.UserProfileScreen
import com.example.facebookclone.util.Common.IMAGE_URL

@Composable
fun ProfileCover() {
  Surface() {
    val avatarUrl: String = IMAGE_URL

    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(354.dp)
        .background(MaterialTheme.colors.surface)
    ) {
      AsyncImage(
        model = Builder(LocalContext.current)
          .data(avatarUrl)
          .crossfade(true)
          .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .height(196.dp)
          .fillMaxWidth()
          .clickable {  }
      )

      Box(
        modifier = Modifier
          .padding(bottom = 170.dp, end = 8.dp)
          .size(40.dp)
          .border(2.dp, PrimaryBg, CircleShape)
          .clip(CircleShape)
          .background(PrimaryBg)
          .align(Alignment.BottomEnd)
          .clickable { },
        contentAlignment = Alignment.Center
      ) {
        Icon(
          Rounded.CameraAlt,
          contentDescription = stringResource(id = string.add),
          tint = Color.Black,
          modifier = Modifier.size(26.dp)
        )
      }

      Box(
        modifier = Modifier
          .padding(start = 8.dp, top = 76.dp)
          .size(158.dp)
          .border(6.dp, Color.White, CircleShape)
          .clip(CircleShape)
          .background(PrimaryBg),
        contentAlignment = Alignment.Center
      ) {
        AsyncImage(
          model = Builder(LocalContext.current)
            .data(avatarUrl)
            .crossfade(true)
            .placeholder(drawable.ic_placeholder)
            .build(),
          contentDescription = null,
          modifier = Modifier
            .fillMaxSize()
            .clip(CircleShape)
          ,
          contentScale = ContentScale.FillBounds,
        )
      }
      Box(
        modifier = Modifier
          .padding(bottom = 116.dp, start = 120.dp)
          .size(40.dp)
          .border(2.dp, PrimaryBg, CircleShape)
          .clip(CircleShape)
          .background(PrimaryBg)
          .align(Alignment.BottomStart)
          .clickable { },
        contentAlignment = Alignment.Center
      ) {
        Icon(
          Rounded.CameraAlt,
          contentDescription = stringResource(id = string.add),
          tint = Color.Black,
          modifier = Modifier.size(26.dp)
        )
      }
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .padding(start = 16.dp, bottom = 78.dp)
          .background(MaterialTheme.colors.surface)
          .align(Alignment.BottomStart),
        contentAlignment = Alignment.BottomStart
      ) {
        Text(text = "Lakshitha Wijewardane", fontSize = 24.sp, fontWeight = FontWeight.Bold)
      }

      Box(
        modifier = Modifier
          .padding(bottom = 18.dp)
          .fillMaxWidth()
          .background(MaterialTheme.colors.surface)
          .align(Alignment.BottomStart),
        contentAlignment = Alignment.Center
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween,
        ) {
          TextButton(
            modifier = Modifier
              .height(36.dp)
              .width(290.dp)
              .padding(start = 16.dp),
            onClick = { },
            colors = ButtonDefaults.textButtonColors(
              backgroundColor = BrandBlue,
              contentColor = MaterialTheme.colors.onSurface
            )
          ) {
            Row() {
              Box(
                modifier = Modifier
                  .padding(end = 4.dp)
                  .size(16.dp)
                  .clip(CircleShape)
                  .background(Color.White),
                contentAlignment = Alignment.Center
              ) {
                Icon(
                  Rounded.Add,
                  contentDescription = stringResource(id = string.add),
                  tint = BrandBlue,
                  modifier = Modifier.size(18.dp),
                )
              }
              Text(text = "Add to Story", color = Color.White, textAlign = TextAlign.Center, fontSize = 14.sp)
            }

          }
          Spacer(modifier = Modifier.weight(1f))
          TextButton(
            modifier = Modifier
              .height(36.dp)
              .width(60.dp)
              .padding(end = 16.dp),
            onClick = { },
            colors = ButtonDefaults.textButtonColors(
              backgroundColor = PrimaryBg,
              contentColor = MaterialTheme.colors.onSurface
            )
          ){
            Icon(
              Rounded.MoreHoriz,
              contentDescription = stringResource(id = string.add),
              tint = Color.Black,
              modifier = Modifier.size(16.dp)
            )
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun PreviewUserProfileScreen(
  navigateToHome: () -> Unit = {}
) {
  UserProfileScreen(navigateToHome)
}
