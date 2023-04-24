package com.example.facebookclone.userprofile.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facebookclone.R.string
import com.example.facebookclone.ui.theme.DarkGray
import com.example.facebookclone.ui.theme.SearchBg

@Composable
fun SearchBar(
  navigateToHome: () -> Unit
) {
  Surface {
    var textState by remember {
      mutableStateOf("")
    }

    Column {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(all = 8.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          Rounded.ArrowBack,
          contentDescription = "",
          modifier = Modifier
            .size(32.dp)
            .clickable {
              navigateToHome()
            }
        )
        BasicTextField(
          value = textState,
          onValueChange = { newText ->
            textState = newText
            // onTextChange(newText)
          },
          decorationBox = { innerTextField ->
            Row(
              modifier = Modifier
                .fillMaxWidth()
                .background(SearchBg, shape = RoundedCornerShape(size = 22.dp))
                .border(
                  width = 2.dp,
                  color = SearchBg,
                  shape = RoundedCornerShape(size = 22.dp)
                )
                .padding( bottom = 4.dp, start = 12.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Favorite icon",
                tint = Color.DarkGray,
                modifier = Modifier.size(20.dp).padding(top = 2.dp)
              )

              if (textState.isEmpty()) {
                Text(
                  text = stringResource(id = string.search),
                  fontSize = 16.sp,
                  fontWeight = FontWeight.Normal,
                  color = DarkGray,
                  modifier = Modifier.padding(start = 4.dp)
                )
              }
              innerTextField()
            }
          },
          modifier = Modifier
            .fillMaxWidth()
            .padding(end = 8.dp)
            .size(36.dp),
        )
      }
    }
  }
}

@Preview
@Composable
fun PreviewSearchBar(
  navigateToHome: () -> Unit = {}
) {
  SearchBar(navigateToHome)
}