package com.mewz.grocery.network.remoteconfig

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

object FirebaseRemoteConfigManager {

    private val remoteConfig = Firebase.remoteConfig

    init {
        val configSetting = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0
        }
        remoteConfig.setConfigSettingsAsync(configSetting)
    }

    fun setUpRemoteConfigWithDefaultValue(){
        val defaultValue: Map<String, Any> = hashMapOf(
            "mainScreenAppBarTitle" to "Grocery App",
            "mainRecyclerLayout" to 0L
        )
        remoteConfig.setDefaultsAsync(defaultValue)
    }

    fun fetchRemoteConfigs(){
        remoteConfig.fetch()
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Log.d("Firebase", "Firebase Remote Config fetch success")
                    remoteConfig.activate().addOnCompleteListener {
                        Log.d("Firebase", "Firebase Remote Config activated")
                    }
                }else {
                    Log.d("Firebase", "Firebase Remote Config fetch failed")
                }
            }
    }

    fun getToolbarName(): String {
        return remoteConfig.getValue("mainScreenAppBarTitle").asString()
    }

    fun getRecyclerViewLayoutNumber(): Long {
        return remoteConfig.getValue("mainRecyclerLayout").asLong()
    }
}