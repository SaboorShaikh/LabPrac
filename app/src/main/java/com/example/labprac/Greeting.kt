package com.example.labprac

import PreferenceManager
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Greeting(modifier: Modifier = Modifier, context: Context = LocalContext.current) {
    var username by remember {
        mutableStateOf(" ")
    }
    val prefManager = PreferenceManager(context)
    val usernamevalues = prefManager.readString("user", "Guest")
    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = username,
            onValueChange = {
                username = it
            }
        )
        Button(
            onClick = { prefManager.writeString("user", username) },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text("Save")
        }
        Text(
            text = usernamevalues,
            fontSize = 20.sp
        )
    }
}
