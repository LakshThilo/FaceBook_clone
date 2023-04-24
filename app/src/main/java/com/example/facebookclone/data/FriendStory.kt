package com.example.facebookclone.data

data class FriendStory(
  val friendName: String,
  val avatarUrl: String,
  val bgUrl: String
  ) {
  companion object {

    fun getListOfFriends(): List<FriendStory> {
      return listOf(
        FriendStory(
          friendName = "Frank Young",
          avatarUrl = "https://images.unsplash.com/photo-1628157588553-5eeea00af15c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1160&q=80",
          bgUrl = "https://images.unsplash.com/photo-1511145822182-677fa5800671?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1738&q=80"
        ),

        FriendStory(
          friendName = "Michel Rampage",
          avatarUrl = "https://images.unsplash.com/photo-1636041282690-8404f759538e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTM0fHxhdmF0YXJ8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
          bgUrl = "https://images.unsplash.com/photo-1539635278303-d4002c07eae3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1740&q=80"
        ),

        FriendStory(
          friendName = "Anand Kumar",
          avatarUrl = "https://images.unsplash.com/photo-1645830166230-187caf791b90?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTI4fHxhdmF0YXJ8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
          bgUrl = "https://images.unsplash.com/photo-1488861859915-4b5a5e57649f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE1fHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=60"
        ),

        FriendStory(
          friendName = "Sue Lee",
          avatarUrl = "https://images.unsplash.com/photo-1568822617270-2c1579f8dfe2?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzN8fGF2YXRhcnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
          bgUrl = "https://images.unsplash.com/photo-1532635241-17e820acc59f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1630&q=80"
        ),

        FriendStory(
          friendName = "John Black",
          avatarUrl = "https://images.unsplash.com/photo-1566492031773-4f4e44671857?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjB8fGF2YXRhcnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
          bgUrl = "https://images.unsplash.com/photo-1501386761578-eac5c94b800a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1740&q=80"
        ),
        FriendStory(
          friendName = "Angie Smith",
          avatarUrl = "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fGF2YXRhcnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
          bgUrl = "https://images.unsplash.com/photo-1520880867055-1e30d1cb001c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1740&q=80"
        ),
      )
    }
  }
}
