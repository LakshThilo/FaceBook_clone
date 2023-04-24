package com.example.facebookclone.userprofile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest.Builder
import com.example.facebookclone.ui.theme.BrandBlue
import com.example.facebookclone.ui.theme.PrimaryTextClrGray
import com.example.facebookclone.userprofile.composable.PostsNReelsSection
import com.example.facebookclone.userprofile.composable.ProfileCover
import com.example.facebookclone.userprofile.composable.ProfileInfo
import com.example.facebookclone.userprofile.composable.SearchBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UserProfileScreen(
  navigateToHome: () -> Unit
) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colors.background)
  ) {
    LazyColumn(
      modifier = Modifier
        .fillMaxSize(),
      contentPadding = PaddingValues(bottom = 40.dp)
    ) {
      item {
        SearchBar(navigateToHome)
      }
      item {
        ProfileCover()
      }
      item {
        Spacer(modifier = Modifier.height(12.dp))
      }
      stickyHeader {
        PostsNReelsSection()
      }
      item {
        ProfileInfo()
      }
      item {
        FriendsList()
      }
      item {
        Spacer(modifier = Modifier.height(12.dp))
      }
      item {
        FriendsList()
      }
    }
  }
}

@Composable
fun FriendsList() {
  Surface {
    Column(
      modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Row(modifier = Modifier) {
        Text(
          text = "Friends",
          fontSize = 20.sp,
          fontWeight = FontWeight.Medium,
          color = Color.Black
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
          text = "Find Friends",
          fontSize = 16.sp,
          fontWeight = FontWeight.Normal,
          color = BrandBlue.copy(alpha = .90f)
        )
      }
      Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
      ) {
        Text(
          text = "2,246 friends",
          fontSize = 14.sp,
          fontWeight = FontWeight.Normal,
          color = PrimaryTextClrGray
        )
      }
      FriendsListRowFirst()
      Spacer(modifier = Modifier.height(8.dp))
      FriendListRowSecond()
      SeeAllFriends()
    }
  }
}

@Composable fun SeeAllFriends() {
  Box(
    modifier = Modifier
      .padding(top = 16.dp)
      .fillMaxWidth()
      .height(36.dp)
      .background(PrimaryTextClrGray.copy(alpha = 0.16f), shape = RoundedCornerShape(6.dp)),
    contentAlignment = Alignment.Center
  ) {
    TextButton(
      modifier = Modifier.fillMaxSize(),
      onClick = { },
      colors = ButtonDefaults.textButtonColors(
        backgroundColor = Color.Transparent,
        contentColor = PrimaryTextClrGray,
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
          text = "See All Friends",
          color = Color.Black,
          textAlign = TextAlign.Center,
          fontWeight = FontWeight.SemiBold
        )
      }
    }
  }
}

@Composable
private fun FriendListRowSecond() {
  Row(
    modifier = Modifier.padding(top = 16.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    SingleFriendCard(
      avatarUrl = "https://images.unsplash.com/photo-1499482125586-91609c0b5fd4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjh8fHBlcnNvbnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
      name = "Charlotte Staner"
    )
    Spacer(modifier = Modifier.width(16.dp))
    SingleFriendCard(
      avatarUrl = "https://images.unsplash.com/photo-1542206395-9feb3edaa68d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzN8fHBlcnNvbnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
      name = "Preethi Mandana"
    )
    Spacer(modifier = Modifier.width(16.dp))
    SingleFriendCard(
      avatarUrl = "https://images.unsplash.com/photo-1555952517-2e8e729e0b44?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fHBlcnNvbnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
      name = "Daniel Lincoln"
    )
  }
}

@Composable
private fun FriendsListRowFirst() {
  Row(
    modifier = Modifier.padding(top = 16.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    SingleFriendCard(
      avatarUrl = "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8cGVyc29ufGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
      name = "John Abraham"
    )
    Spacer(modifier = Modifier.width(16.dp))
    SingleFriendCard(
      avatarUrl = "https://images.unsplash.com/photo-1504593811423-6dd665756598?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fHBlcnNvbnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
      name = "Nadi Sharon"
    )
    Spacer(modifier = Modifier.width(16.dp))
    SingleFriendCard(
      avatarUrl = "https://images.unsplash.com/photo-1500259783852-0ca9ce8a64dc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjZ8fHBlcnNvbnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
      name = "Michelle Austine"
    )
  }
}

@Composable
private fun SingleFriendCard(
  avatarUrl: String,
  name: String
) {
  Column {
    Card(
      modifier = Modifier
        .size(100.dp, 110.dp)
        .border(1.dp, Color.Transparent, MaterialTheme.shapes.medium),
    ) {
      Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
          model = Builder(LocalContext.current)
            .data(avatarUrl)
            .crossfade(true)
            .build(),
          contentDescription = null,
          contentScale = ContentScale.Crop,
        )
      }
    }
    Spacer(modifier = Modifier.height(4.dp))
    Text(text = name)
  }
}

@Preview
@Composable
fun PreviewUserProfileScreen(
  navigateToHome: () -> Unit = {}
) {
  UserProfileScreen(navigateToHome)
}
