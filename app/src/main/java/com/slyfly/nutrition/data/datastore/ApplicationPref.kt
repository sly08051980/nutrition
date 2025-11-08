package com.slyfly.nutrition.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "Local_datastore"
)
class ApplicationPref(val context : Context) {

    private val dataStore: DataStore<Preferences> get()=context.dataStore


    suspend fun saveStringPref(key:String,value:String){
        dataStore.edit{
            it[stringPreferencesKey(key)]=value
        }

    }
    suspend fun saveBooleanPref(key:String,value: Boolean){
       dataStore.edit{
            it[booleanPreferencesKey(key)]=value
        }
    }
    suspend fun getStringPref(key: String):String?{
        return dataStore.data.map {
            it[stringPreferencesKey(key)]
        }.first()
    }

    suspend fun getBooleanPref(key: String):Boolean?{
        return dataStore.data.map {
            it[booleanPreferencesKey(key)]
        }.first()
    }
}