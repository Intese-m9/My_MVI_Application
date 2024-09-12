package com.example.mymviapplication.domain.permissions

import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

@Composable
fun RuntimePermissionDialog(
    permission: String,
    onPermissionGranted: () -> Unit,
    onPermissionDenied: () -> Unit,
) {
    if (ContextCompat.checkSelfPermission(
            LocalContext.current,
            permission
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        val requestLocationPermissionLauncher =
            rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
                if (isGranted) {
                    onPermissionGranted()
                } else {
                    onPermissionDenied()
                }
            }
        SideEffect {
            requestLocationPermissionLauncher.launch(permission)
        }
    }
}

