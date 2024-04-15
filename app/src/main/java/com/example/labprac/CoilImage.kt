package com.example.labprac

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.State
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImagePainter
import coil.compose.ImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest

@Composable
fun CoilImage(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(data = "https://cdn.pixabay.com/photo/2016/05/05/02/37/sunset-1373171_1280.jpg")
                .apply(block = fun ImageRequest.Builder.() {
                    crossfade(1000)
                }).build()
        )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "")
        if (painterState is AsyncImagePainter.State.Loading){
            CircularProgressIndicator()
        }
    }
}

@Preview (showBackground = true)
@Composable
fun CoilImagesPreview() {
    CoilImage(navController = rememberNavController())
}