package com.example.facebookclone.data

data class FriendInfo(
  val avatarUrl: String,
  val name: String
){

  companion object {
    fun getFriendsInfo(): List<FriendInfo>{
      return listOf(
        FriendInfo(
          avatarUrl = "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8cGVyc29ufGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
          name = "John Abraham"
        ),
        FriendInfo(
          avatarUrl = "https://images.unsplash.com/photo-1504593811423-6dd665756598?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fHBlcnNvbnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
          name = "Nadi Sharon"
        ),
        FriendInfo(
          avatarUrl = "https://images.unsplash.com/photo-1500259783852-0ca9ce8a64dc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjZ8fHBlcnNvbnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
          name = "Michelle Austine"
        ),
        FriendInfo(
          avatarUrl = "https://images.unsplash.com/photo-1499482125586-91609c0b5fd4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjh8fHBlcnNvbnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
          name = "Charlotte Staner"
        ),
        FriendInfo(
          avatarUrl = "https://images.unsplash.com/photo-1542206395-9feb3edaa68d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzN8fHBlcnNvbnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
          name = "Preethi Mandana"
        ),
        FriendInfo(
          avatarUrl = "https://images.unsplash.com/photo-1555952517-2e8e729e0b44?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fHBlcnNvbnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
          name = "Daniel Lincoln"
        )
      )
    }
  }
}