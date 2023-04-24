package com.example.facebookclone.homescreen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest.Builder
import com.example.facebookclone.R.drawable
import com.example.facebookclone.R.string
import com.example.facebookclone.ui.theme.BackgroundGray
import com.example.facebookclone.ui.theme.DarkGray

@Composable
fun StatusUpdateBar(
  avatarUrl: String,
  navigateToUserProfile:() -> Unit,
  onTextChange: (String) -> Unit,
  onSendClick: () -> Unit
) {
  Surface {

    var text by remember {
      mutableStateOf("")
    }
    Column {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 8.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        AsyncImage(
          model = Builder(LocalContext.current)
            .data(avatarUrl)
            .crossfade(true)
            .placeholder(drawable.ic_placeholder)
            .build(),
          contentDescription = null,
          modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .clickable { navigateToUserProfile() }
          ,
          contentScale = ContentScale.FillBounds,
        )
        Spacer(modifier = Modifier.width(8.dp))
        BasicTextField(
          value = text,
          onValueChange = { newText ->
            text = newText
            onTextChange(newText)
          },
          decorationBox = { innerTextField ->
            Box(
              modifier = Modifier
                .fillMaxWidth()
                .border(
                  width = 2.dp,
                  color = BackgroundGray,
                  shape = RoundedCornerShape(size = 16.dp)
                )
                .padding(start = 16.dp, top = 10.dp, bottom = 8.dp),
            ) {
              if (text.isEmpty()) {
                Text(
                  text = stringResource(id = string.whats_on_your_mind),
                  fontSize = 18.sp,
                  fontWeight = FontWeight.Normal,
                  color = DarkGray
                )
              }
              innerTextField()
            }
          },
          keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Send
          ),
          keyboardActions = KeyboardActions(
            onSend = {
              onSendClick()
              text = ""
            }
          ),
          textStyle = TextStyle(
            fontSize = 20.sp,
            color = Color.DarkGray
          ),
          modifier = Modifier
            .weight(1f)
            .height(42.dp)
            .fillMaxWidth(),
        )

        Image(painter = painterResource(id = drawable.ic_image_load),
          contentDescription = null,
          modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .height(28.dp)
            .clickable {
              navigateToUserProfile()
            }
        )
      }
      Divider(thickness = Dp.Hairline)
    }
  }
}


@Preview
@Composable
fun PreviewStatusUpdateBar(
  avatarUrl: String = "",
  navigateToUserProfile: () -> Unit = {},
  onTextChange: (String) -> Unit = {},
  onSendClick: () -> Unit = {}
) {
  val avatarUrl = "https://images.unsplash.com/flagged/photo-1570612861542-284f4c12e75f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"
  StatusUpdateBar(
    avatarUrl = avatarUrl,
    navigateToUserProfile = navigateToUserProfile,
    onTextChange = onTextChange,
    onSendClick = onSendClick
  )
}

/*

  TextField(
      value = textState,
      modifier = Modifier
        .weight(1f)
        .height(36.dp)
        .clip(RoundedCornerShape(35.dp))
        .border(
          width = 1.dp,
          brush = Brush.horizontalGradient(listOf(LightGray, LightGray)),
          shape = RoundedCornerShape(35.dp)
        ),
      colors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent,
        cursorColor = Color.Transparent,
        disabledLabelColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
      ),
      onValueChange = {},
      label = {
        Text(
          text = stringResource(id = R.string.whats_on_your_mind),
          textAlign = TextAlign.Center)}
  )
*/