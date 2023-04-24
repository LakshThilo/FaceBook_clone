package com.example.facebookclone.homescreen.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebookclone.R.string

@Composable
fun LikeNCommentSection() {
  Surface {
    Row(modifier = Modifier.fillMaxWidth()) {
      StatusAction(
        icon = Outlined.ThumbUp,
        text = stringResource(id = string.like),
        modifier = Modifier
          .weight(1f)
          .size(36.dp),
        MaterialTheme.colors.background
      )
      StatusAction(
        Outlined.Chat,
        stringResource(id = string.comment),
        modifier = Modifier
          .weight(1f)
          .size(36.dp),
        MaterialTheme.colors.background
      )

      StatusAction(
        Outlined.Share,
        stringResource(id = string.share),
        modifier = Modifier
          .weight(1f)
          .size(36.dp),
        MaterialTheme.colors.background
      )
    }
  }
}

@Preview
@Composable
fun PreviewLikeNCommentSection() {
  LikeNCommentSection()
}