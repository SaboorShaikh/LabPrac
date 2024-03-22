package com.example.labprac

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current
) {
    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    var imageBitmap by remember {
        mutableStateOf<ImageBitmap?>(null)
    }
    val cameraLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            val bitmap = it.data?.extras?.get("data") as Bitmap
            imageBitmap = bitmap.asImageBitmap()
        } else {
            Toast.makeText(context, "Picture capture cancelled", Toast.LENGTH_SHORT).show()

        }
    }
    val permissionRequestLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(context, "Permission granted", Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(intent)
        } else {
            Toast.makeText(context, "Permission denied", Toast.LENGTH_SHORT).show()

        }
    }
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Main Screen") }) },
        bottomBar = {
            BottomAppBar {
                Text("Bottom Bar")
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text(text = "Main Screen")
            Button(onClick = {
            }) {
                Text("Next Screen")
            }
            Button(onClick = {
                if (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.CAMERA
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    Toast.makeText(context, "Permission is given", Toast.LENGTH_SHORT).show()
                    cameraLauncher.launch(intent)
                } else {
                    permissionRequestLauncher.launch(Manifest.permission.CAMERA)
                }
            }) {
                Text("Open Camera")
            }
            imageBitmap?.let {
                Image(bitmap = it, contentDescription = "", modifier = Modifier.fillMaxSize())
            }
        }
    }
}