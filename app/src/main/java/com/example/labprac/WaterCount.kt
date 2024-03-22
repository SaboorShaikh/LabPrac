package com.example.labprac

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun WaterCount(modifier: Modifier = Modifier, context: Context = LocalContext.current) {
    val count = remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "You have taken ${count.intValue} cups today")
        Button(onClick = {
            count.intValue++
        }) {
            Text(text = "Add Cup")
        }
    }
}