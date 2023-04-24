package com.example.facebookclone.util.samples/*
package com.example.facebookclone.util

import android.Manifest
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestPermission(): ActivityResultContract<Any, Any> {
  val permissionsState = rememberMultiplePermissionsState(
    permissions = listOf(
      Manifest.permission.CAMERA,
      Manifest.permission.RECORD_AUDIO,
    )
  )

  permissionsState.permissions.forEach { perms ->
    when(perms.permission){
      Manifest.permission.CAMERA -> {
        when {
          perms.hasPermission -> {
              Text(text = "CAMERA permission granted")
          }
          perms.shouldShowRationale -> {
            Text(text = "CAMERA permission is needed to access the camera")
          }
          !perms.hasPermission && !perms.shouldShowRationale -> {
            Text(text = "CAMERA permission is permanently Denied you can enable it into app setting")
          }
        }
      }
      Manifest.permission.RECORD_AUDIO -> {
        when {
          perms.hasPermission -> {
            Text(text = "Audio permission granted")
          }
          perms.shouldShowRationale -> {
            Text(text = "Audio permission is needed to access the microphone")
          }
          perms.isPermanentlyDenied() -> {
            Text(text = "Audio permission is permanently Denied you can enable it into app setting")
          }
        }
      }
    }
  }
}

@OptIn(ExperimentalPermissionsApi::class)
fun PermissionState.isPermanentlyDenied() : Boolean {
  return !hasPermission && !shouldShowRationale
}*/
