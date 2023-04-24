package com.example.facebookclone.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.facebookclone.data.Post
import com.example.facebookclone.homescreen.HomeScreenState.Loaded
import com.example.facebookclone.homescreen.HomeScreenState.Loading
import com.example.facebookclone.homescreen.HomeScreenState.SignInRequired
import com.facebook.AccessToken
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.Date

sealed class HomeScreenState {
  object Loading: HomeScreenState()
  data class Loaded(
    val avatarUrl: String,
    val posts: List<Post>
  ): HomeScreenState()
  object SignInRequired: HomeScreenState()
}


class HomeViewModel : ViewModel() {

  private val mutableState = MutableStateFlow<HomeScreenState>(Loading)
  val state = mutableState.asStateFlow()

  private val textState = MutableStateFlow("")

  init {
    viewModelScope.launch(Dispatchers.IO) {
      val currentUser = Firebase.auth.currentUser
      if(currentUser != null ){
        observePosts(currentUser)
      } else {
        mutableState.emit(
          SignInRequired
        )
      }
    }
  }

  private suspend fun observePosts(currentUser: FirebaseUser) {
    observePosts().map { posts ->
      Loaded(
        avatarUrl = getAvatarUrl(currentUser),
        posts = posts
      )
    }.collect {
      mutableState.emit(it)
    }
  }

  private fun observePosts(): Flow<List<Post>> {
    // this will convert api base callback into a flow, then we can subscribe in UI
    return callbackFlow<List<Post>> {
      // everytime post added/updated this callback(addSnapshotListener) will trigger
      val listener = Firebase.firestore.collection("posts").addSnapshotListener { value, error ->
        if (error != null) {
          close(error)
        } else {
          if (value != null) {
            val posts = value.map { documentSnapshot ->
              Post(
                text = documentSnapshot.getString("text").orEmpty(),
                timestamp = documentSnapshot.getDate("date_posted") ?: Date(),
                authorName = documentSnapshot.getString("author_name").orEmpty(),
                authorAvatarUrl = documentSnapshot.getString("author_avatar_url").orEmpty(),
              )
            }.sortedByDescending { it.timestamp }
            trySend(posts) // once we get the value we emit it to flow
          }
        }
      }
      awaitClose {
        // this block is call when no one is listening callback / when flow close - release flow
        listener.remove()
      }
    }
  }

  private fun getAvatarUrl(currentUser: FirebaseUser): String {
    val accessToken = AccessToken.getCurrentAccessToken()?.token
    return "${requireNotNull(currentUser.photoUrl)}?access_token=$accessToken&type=large"
  }

  fun onTextChange(text: String) {
    viewModelScope.launch {
      textState.emit(text)
    }
  }

  fun onSendClick() {
    viewModelScope.launch(Dispatchers.IO) {
      val postText = textState.value
      val currentUser = requireNotNull(Firebase.auth.currentUser) {
        "Try to create a post without sign in a user"
      }
      Firebase.firestore.collection("posts")
        .add(
          hashMapOf(
            "text" to postText,
            "date_posted" to Date(),
            "author_name" to currentUser.displayName.orEmpty(),
            "author_avatar_url" to getAvatarUrl(currentUser)
          )
        )
    }
  }
}