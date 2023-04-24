package com.example.facebookclone.homescreen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable fun LoadingScreen() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colors.surface),
    contentAlignment = Alignment.Center
  ) {
    CircularProgressIndicator()
  }
}


@Preview
@Composable
fun PreviewLoadingScreen() {
   LoadingScreen()
}