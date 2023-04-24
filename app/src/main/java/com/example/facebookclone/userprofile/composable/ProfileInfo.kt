package com.example.facebookclone.userprofile.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

@Composable
fun ProfileInfo() {
  Surface {
    Column(modifier = Modifier.fillMaxSize()) {
      Divider(thickness = Dp.Hairline)
      ProfileDetailsSection()
      StoriesSection()
      EditPublicDetailsSection()
    }
  }
}

@Preview
@Composable
fun PreviewProfileInfo() {
  ProfileInfo()
}