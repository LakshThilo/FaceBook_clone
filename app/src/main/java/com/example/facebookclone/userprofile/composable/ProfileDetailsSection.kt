package com.example.facebookclone.userprofile.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.MoreHoriz
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facebookclone.R.drawable
import com.example.facebookclone.ui.theme.PrimaryTextClrGray

@Composable
fun ProfileDetailsSection() {
  Column(Modifier.fillMaxSize()) {
    Row(
      Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Start
    ) {
      Text(text = "Details", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, bottom = 12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Start
    ) {
      Icon(
        painter = painterResource(id = drawable.ic_business_center),
        contentDescription = "",
        tint = PrimaryTextClrGray
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = "Former IOS/Android Developer at Capital One",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black.copy(alpha = .76f)
      )
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, bottom = 12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Start
    ) {
      Icon(
        painter = painterResource(id = drawable.ic_school),
        contentDescription = "",
        tint = PrimaryTextClrGray
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = "Studied at University of Wolverhampton",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black.copy(alpha = .76f)
      )
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, bottom = 12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Start
    ) {
      Icon(
        painter = painterResource(id = drawable.ic_cottage),
        contentDescription = "",
        tint = PrimaryTextClrGray
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = "Live in Birmingham, United Kingdom",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black.copy(alpha = .76f)
      )
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, bottom = 12.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Start
    ) {
      Icon(Rounded.LocationOn, contentDescription = "", tint = PrimaryTextClrGray)
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = "From Anuradhapura",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black.copy(alpha = .76f)
      )
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, bottom = 16.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Start
    ) {
      Icon(
        painter = painterResource(id = drawable.ic_favorite),
        contentDescription = "",
        tint = PrimaryTextClrGray
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = "Married",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black.copy(alpha = .76f)
      )
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, bottom = 16.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Start
    ) {
      Icon(
        painter = painterResource(id = drawable.ic_time),
        contentDescription = "",
        tint = PrimaryTextClrGray
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = "Joined on January 2014",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black.copy(alpha = .76f)
      )
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, bottom = 16.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Start
    ) {
      Icon(Rounded.MoreHoriz, contentDescription = "", tint = PrimaryTextClrGray)
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = "See your about info",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black.copy(alpha = .76f)
      )
    }
  }
}

@Preview
@Composable
fun ProfileDetailsSectionPreview() {
  ProfileDetailsSection()
}