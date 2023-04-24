package com.example.facebookclone.singin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Facebook
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.facebookclone.R.string
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@Composable
fun SignInScreen(
  navigateToHome: () -> Unit
) {

  val context = LocalContext.current
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colors.surface)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 120.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Icon(
        Icons.Rounded.Facebook,
        contentDescription = null,
        modifier = Modifier.size(90.dp),
        tint = MaterialTheme.colors.primary
      )

      Spacer(modifier = Modifier.height(8.dp))

      SigninButton(
        onSignIn = navigateToHome,
        onSigninFail = {
          Toast.makeText(context, context.getString( string.error_message), Toast.LENGTH_SHORT).show()
        }
      )

      Text(text = stringResource(string.sign_in_with_facebook))
    }
  }
}

@Composable fun SigninButton(
  onSigninFail: (Exception) -> Unit,
  onSignIn: () -> Unit
) {
  val scope = rememberCoroutineScope()
  AndroidView({ context ->
    LoginButton(context).apply {
      setPermissions("email","public_profile")
      val callbackManager = CallbackManager.Factory.create()
      registerCallback(callbackManager, object: FacebookCallback<LoginResult>{
        override fun onCancel() {
        }

        override fun onError(error: FacebookException) {
          onSigninFail(error)
        }

        override fun onSuccess(result: LoginResult) {
          scope.launch {
            val token = result.accessToken.token
            val credential = FacebookAuthProvider.getCredential(token)
            val authResult = Firebase.auth.signInWithCredential(credential).await()
            if(authResult.user != null){
              onSignIn()
            } else {
              onSigninFail(RuntimeException("Couldn't sign in with firebase"))
            }
          }
        }
      })
    }
  })
}
