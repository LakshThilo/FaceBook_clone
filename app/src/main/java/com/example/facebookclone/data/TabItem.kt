package com.example.facebookclone.data

import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LiveTv
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.PeopleOutline
import androidx.compose.material.icons.rounded.Store
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.facebookclone.R.string

data class TabItem(
  val imageVector: ImageVector,
  val contentDescription: Int
) {
  companion object {
    fun getTabItems() = listOf(
      TabItem(Rounded.Home,  string.home),
      TabItem(Rounded.PeopleOutline, string.people),
      TabItem(Rounded.LiveTv, string.reel),
      TabItem(Rounded.Store, string.market),
      TabItem(Rounded.Notifications, string.notification),
      TabItem(Rounded.Menu, string.menu),
    )
  }
}

data class TabItems(
  val imageVector: ImageVector,
  val contentDescription: String
)