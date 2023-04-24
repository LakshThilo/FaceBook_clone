package com.example.facebookclone.homescreen.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Movie
import androidx.compose.material.icons.rounded.Photo
import androidx.compose.material.icons.rounded.VideoCall
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.facebookclone.R.string
import com.example.facebookclone.ui.theme.DarkGreen

@Composable
fun GoLiveSection() {
  Surface {
    Row(modifier = Modifier.fillMaxWidth()) {
      StatusAction(
        Rounded.VideoCall,
        stringResource(id = string.live),
        modifier = Modifier.weight(1f),
        Color.Red
      )
      VerticalDivider(Modifier.height(48.dp), thickness = Dp.Hairline)
      StatusAction(
        Rounded.Movie,
        stringResource(id = string.reel),
        modifier = Modifier.weight(1f),
        Color.Red.copy(alpha = 0.45f)
      )
      VerticalDivider(Modifier.height(48.dp), thickness = Dp.Hairline)
      StatusAction(
        Rounded.Photo,
        stringResource(id = string.photo),
        modifier = Modifier.weight(1f),
        DarkGreen.copy(alpha = 0.55f)
      )
    }
  }
}

@Preview
@Composable
fun PreviewGoLiveSection() {
  GoLiveSection()
}