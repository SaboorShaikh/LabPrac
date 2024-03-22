package com.example.labprac

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

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