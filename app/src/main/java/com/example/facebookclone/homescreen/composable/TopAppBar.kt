package com.example.facebookclone.homescreen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Message
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebookclone.R.string
import com.example.facebookclone.ui.theme.ButtonGray

@Composable
fun TopAppBar() {
  Surface {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 8.dp),
    ) {
      Text(text = stringResource(id = string.app_name), style = MaterialTheme.typography.h6)
      Spacer(modifier = Modifier.weight(1f))

      IconButton(
        onClick = { },
        modifier = Modifier
          .clip(CircleShape)
          .background(ButtonGray)
          .size(34.dp)
      ) {
        Icon(
          Rounded.Add,
          contentDescription = stringResource(id = string.search),
          modifier = Modifier

        )
      }
      Spacer(modifier = Modifier.width(8.dp))

      IconButton(
        onClick = { },
        modifier = Modifier
          .clip(CircleShape)
          .background(ButtonGray)
          .size(34.dp)
      ) {
        Icon(
          Rounded.Search,
          contentDescription = stringResource(id = string.search),
          modifier = Modifier

        )
      }
      Spacer(modifier = Modifier.width(8.dp))
      IconButton(
        onClick = { },
        modifier = Modifier
          .clip(CircleShape)
          .background(ButtonGray)
          .size(34.dp)
      ) {
        Icon(
          Rounded.Message,
          contentDescription = stringResource(id = string.message),
          modifier = Modifier.size(22.dp)

        )
      }
    }
  }
}

@Preview
@Composable
fun PreviewTopAppBar() {
  TopAppBar()
}