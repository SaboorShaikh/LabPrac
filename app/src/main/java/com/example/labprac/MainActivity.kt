package com.example.labprac

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.labprac.ui.theme.LabPracTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabPracTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    myApp()
                }
            }
        }
    }
}

class DatastoreManager(context: Context) {
    private val thisContext = context
    private val Context.dataStore by preferencesDataStore(name = "prefs")
    private val ageKey = intPreferencesKey(name = "age")

    suspend fun saveAge(age: Int) {
        thisContext.dataStore.edit {
            it[ageKey] = age
        }
    }

    suspend fun getAge(): Int {
        val ageFlow = thisContext.dataStore.data.map {
            it[ageKey] ?: 0
        }
        return ageFlow.first()
    }
}

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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    WaterCount()
//    MainScreen()
//    LoginScreen()
//    Greeting()
    myApp()
}