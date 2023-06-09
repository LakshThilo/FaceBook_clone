package com.example.facebookclone.data

import java.util.Date

data class Post(
  val text: String,
  val timestamp: Date,
  val authorName: String,
  val authorAvatarUrl: String
)
