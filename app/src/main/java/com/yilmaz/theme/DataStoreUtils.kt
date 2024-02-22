package com.yilmaz.theme

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreUtils(private val context: Context) {

    fun getTheme(): Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[THEME_KEY] ?: themes[0]
        }

    suspend fun setTheme(theme: String) {
        context.dataStore.edit { preferences ->
            preferences[THEME_KEY] = theme
        }
    }

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")
        private val THEME_KEY = stringPreferencesKey("theme")

        val themes = listOf(
            "System setting",
            "Dark mode",
            "Light mode"
        )
    }

}