package com.example.facebookclone.homescreen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable fun Scrim(modifier: Modifier) {
  Box(
    modifier = modifier
      .background(
        Brush.verticalGradient(
          listOf(
            Color.Transparent, Color(0x40000000)
          )
        )
      )
  )
}

@Preview
@Composable
fun PreviewScrim(){
  Scrim(modifier = Modifier)
}