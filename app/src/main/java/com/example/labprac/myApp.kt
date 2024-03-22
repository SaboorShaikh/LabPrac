package com.example.labprac

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch

@Composable
fun myApp(modifier: Modifier = Modifier, context: Context = LocalContext.current) {
    val dataMgr = DatastoreManager(context)
    val scope = rememberCoroutineScope()
    val age = remember {
        mutableStateOf(0)
    }
    LaunchedEffect(Unit) {
        age.value = dataMgr.getAge()
    }
    Column {
        Button(onClick = {
            scope.launch {
                dataMgr.saveAge(28)
            }
        }) {
            Text(text = "Save User")
        }
        Text(age.value.toString())
    }
}