package com.example.facebookclone.homescreen.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebookclone.data.FriendStory

@Composable
fun StoriesSections(
  avatarUrl: String
) {
  val friendsStories = FriendStory.getListOfFriends()
  Surface {
    LazyRow(
      modifier = Modifier.fillMaxWidth(),
      contentPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      item {
        UserStoryCard(avatarUrl)
      }

      items(friendsStories){ stories ->
        StoryCard(stories)
      }
    }
  }
}

@Preview
@Composable
fun PreviewStoriesSections(
  avatarUrl: String = ""
){
  val avatarUrl = "https://images.unsplash.com/flagged/photo-1570612861542-284f4c12e75f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"

  StoriesSections(avatarUrl)
}