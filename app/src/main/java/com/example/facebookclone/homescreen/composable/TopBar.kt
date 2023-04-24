package com.example.facebookclone.homescreen.composable

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebookclone.data.TabItem

@Composable
fun TopBar() {

  Surface {
    var tabIndex by remember {
      mutableStateOf(0)
    }

    val tabs = TabItem.getTabItems()

    TabRow(
      selectedTabIndex = tabIndex,
      backgroundColor = Color.Transparent,
      contentColor = MaterialTheme.colors.primary
    ) {

      tabs.forEachIndexed { i, item ->
        Tab(
          selected = tabIndex == i,
          onClick = { tabIndex = i },
          modifier = Modifier.height(48.dp)
        ) {
          Icon(
            item.imageVector,
            contentDescription = stringResource(id = item.contentDescription),
            tint = if (i == tabIndex) {  // change selected and unselected color
              MaterialTheme.colors.primary
            } else {
              MaterialTheme.colors.onSurface.copy(alpha = 0.44f)
            },
            modifier = Modifier.size(26.dp)
          )
        }
      }
    }
  }
}

@Preview
@Composable
fun PreviewTopBar() {
  TopBar()
}