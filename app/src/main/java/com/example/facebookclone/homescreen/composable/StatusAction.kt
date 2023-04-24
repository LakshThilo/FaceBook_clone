package com.example.facebookclone.homescreen.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatusAction(
  icon: ImageVector,
  text: String,
  modifier: Modifier = Modifier,
  color: Color
) {
  Row(modifier.fillMaxWidth()) {
    TextButton(
      modifier = modifier,
      onClick = { },
      colors = ButtonDefaults.textButtonColors(
        backgroundColor = Color.Transparent,
        contentColor = MaterialTheme.colors.onSurface
      )
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
          icon,
          contentDescription = text,
          tint = color
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = text, color = Color.Black)
      }
    }
  }
}

@Preview
@Composable
fun PreviewStatusAction(
  icon: ImageVector = Outlined.Share,
  text: String = "Share",
  modifier: Companion = Modifier,
  color: Color = MaterialTheme.colors.primary
) {
  StatusAction(icon,text, modifier,color)
}