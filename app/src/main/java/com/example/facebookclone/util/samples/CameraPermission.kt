package com.example.facebookclone.util.samples

import android.Manifest
import android.Manifest.permission
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Camera
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import kotlinx.coroutines.launch

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequiredPermission() {
  val state = rememberPermissionState(Manifest.permission.CAMERA)
  Scaffold {
    when {
      state.status.isGranted -> CameraScreen()
      else -> {
        LaunchedEffect(Unit) {
          state.launchPermissionRequest()
        }
        Box(
          Modifier
          .fillMaxSize()
          .background(MaterialTheme.colors.background)) {
          Column(Modifier.padding(vertical = 120.dp, horizontal = 16.dp)) {
            Icon(
              Icons.Rounded.Camera,
              contentDescription = null,
              tint = MaterialTheme.colors.onBackground)
            Spacer(Modifier.height(8.dp))
            Text("Camera permission required", style = MaterialTheme.typography.h6)
            Spacer(Modifier.height(4.dp))
            Text("This is required in order for the app to take pictures")
          }
          val context = LocalContext.current
          Button(
            modifier = Modifier
              .align(Alignment.BottomCenter)
              .fillMaxWidth()
              .padding(16.dp),
            onClick = {
              val intent =
                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                  data = Uri.fromParts("package", context.packageName, null)
                }
              startActivity(context,intent,null)
            }) {
            Text("Go to settings")
          }
        }
      }
    }
  }
}

@Composable fun CameraScreen() {

}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun OptionalPermissionScreen() {
  val context = LocalContext.current.applicationContext

  val state = rememberPermissionState(Manifest.permission.CAMERA)
  val scaffoldState = rememberScaffoldState()
  val launcher = rememberLauncherForActivityResult(RequestPermission()) { wasGranted ->
    if (wasGranted as Boolean) {
      // TODO do work (ie forward to viewmodel)
      Toast.makeText(context, "📸 Photo in 3..2..1", Toast.LENGTH_SHORT).show()
    }
  }
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    scaffoldState = scaffoldState,
    floatingActionButton = {
      val scope = rememberCoroutineScope()
      val snackbarHostState = scaffoldState.snackbarHostState

      FloatingActionButton(onClick = {
        when (state.status) {
          PermissionStatus.Granted -> {
            // TODO do work (ie forward to viewmodel)
            Toast.makeText(context, "📸 Photo in 3..2..1", Toast.LENGTH_SHORT).show()
          }
          else -> {
            if (state.status.shouldShowRationale) {
              scope.launch {
                val result =
                  snackbarHostState.showSnackbar(
                    message = "Permission required",
                    actionLabel = "Go to settings"
                  )
                if (result == SnackbarResult.ActionPerformed) {
                  val intent = Intent(
                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", context.packageName, null)
                  )
                  startActivity(context, intent, null)
                }
              }
            } else {
              launcher.launch(permission.CAMERA)
            }
          }
        }
      }) {
        Icon(Icons.Rounded.Camera, contentDescription = null)
      }
    }) {
    // the rest of your screen
  }
}

