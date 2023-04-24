package com.example.facebookclone.userprofile.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebookclone.ui.theme.BrandBlue
import com.example.facebookclone.ui.theme.PrimaryTextClrGray

@Composable
fun PostsNReelsSection() {
  Surface {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, bottom = 8.dp, start = 16.dp)
    ) {
      Box(
        modifier = Modifier
          .height(36.dp)
          .width(56.dp)
          .background(BrandBlue.copy(alpha = 0.08f), shape = RoundedCornerShape(18.dp))
          .align(Alignment.CenterVertically),
        contentAlignment = Alignment.Center
      ) {
        TextButton(
          modifier = Modifier.fillMaxSize(),
          onClick = { },
          colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Transparent,
            contentColor = BrandBlue.copy(alpha = 0.08f),
            disabledContentColor = MaterialTheme.colors.surface,
          ),
          enabled = true
        ) {
          Box(
            modifier = Modifier
              .height(36.dp)
              .width(56.dp)
              .align(Alignment.CenterVertically),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = "Posts",
              color = BrandBlue,
              textAlign = TextAlign.Center,
              fontWeight = FontWeight.SemiBold
            )
          }
        }
      }

      Box(
        modifier = Modifier
          .padding(start = 8.dp)
          .height(36.dp)
          .width(56.dp)
          .background(MaterialTheme.colors.surface, shape = RoundedCornerShape(18.dp))
          .align(Alignment.CenterVertically),
        contentAlignment = Alignment.Center
      ) {
        TextButton(
          modifier = Modifier,
          onClick = { },
          colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Transparent,
            contentColor = MaterialTheme.colors.onSurface
          )
        ) {
          Box(
            modifier = Modifier
              .height(36.dp)
              .width(56.dp)
              .align(Alignment.CenterVertically),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = "Reels",
              color = PrimaryTextClrGray,
              textAlign = TextAlign.Center,
              fontWeight = FontWeight.Bold
            )
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun PostsNReelsSectionPreview(){
  PostsNReelsSection()
}