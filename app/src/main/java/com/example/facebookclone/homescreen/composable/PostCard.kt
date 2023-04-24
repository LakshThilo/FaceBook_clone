package com.example.facebookclone.homescreen.composable

import android.text.format.DateUtils
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.MoreHoriz
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest.Builder
import com.example.facebookclone.R
import com.example.facebookclone.R.drawable
import com.example.facebookclone.R.string
import com.example.facebookclone.data.Post
import java.util.Date

@Composable
fun PostCard(
  post: Post
) {
  Surface {
    Column {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        AsyncImage(
          model = Builder(LocalContext.current)
            .data(post.authorAvatarUrl)
            .crossfade(true)
            .placeholder(drawable.ic_placeholder)
            .build(),
          contentDescription = null,
          contentScale = ContentScale.FillBounds,
          modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
        )
        Column(
          modifier = Modifier
            .weight(1f)
            .padding(horizontal = 8.dp)
        ) {

          Text(
            text = post.authorName,
            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Medium)
          )
          val date = remember {
            Date()
          }
          Text(
            dateLabel(timestamp = post.timestamp, today = date),
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.66f)
          )
        }
        IconButton(onClick = { }) {
          Icon(Rounded.MoreHoriz, contentDescription = stringResource(id = string.menu))
        }
      }
      Text(
        text = post.text,
        style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Medium),
        modifier = Modifier
          .fillMaxWidth()
          .padding(8.dp)
      )
      Spacer(modifier = Modifier.height(8.dp))

      Divider(thickness = Dp.Hairline)

      LikeNCommentSection()
    }
  }
}


@Composable
private fun dateLabel(timestamp: Date, today: Date): String {
  // Just now
  // 5min ago
  return if (today.time - timestamp.time < 2 * DateUtils.MINUTE_IN_MILLIS) {
    stringResource(id = R.string.just_now)
  } else {
    DateUtils.getRelativeTimeSpanString(
      timestamp.time, today.time, DateUtils.MINUTE_IN_MILLIS,
      DateUtils.FORMAT_SHOW_DATE
    ).toString()
  }
}


@Preview
@Composable
fun PreviewPostCard(
  post: Post = Post(text = "", timestamp = Date(), authorName = "Test Name", authorAvatarUrl = "")
) {
  PostCard(post = post)
}