package com.example.facebookclone.userprofile.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
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

@Composable
fun EditPublicDetailsSection() {
  Surface {
    Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Box(
        modifier = Modifier
          .padding(start = 16.dp, end = 16.dp, top = 8.dp)
          .fillMaxWidth()
          .height(36.dp)
          .background(BrandBlue.copy(alpha = 0.12f), shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
      ) {
        TextButton(
          modifier = Modifier.fillMaxSize(),
          onClick = { },
          colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Transparent,
            contentColor = BrandBlue.copy(alpha = 0.18f),
            disabledContentColor = MaterialTheme.colors.surface,
          ),
          enabled = true
        ) {
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .height(36.dp)
              .align(Alignment.CenterVertically),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = "Edit Public Details",
              color = BrandBlue,
              textAlign = TextAlign.Center,
              fontWeight = FontWeight.SemiBold
            )
          }
        }
      }
      Divider(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
    }
  }
}

@Preview
@Composable
fun PreviewEditPublicDetailsSection() {
  EditPublicDetailsSection()
}