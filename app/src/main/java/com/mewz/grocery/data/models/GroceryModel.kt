package com.mewz.grocery.data.models

import android.graphics.Bitmap
import com.mewz.grocery.data.vos.GroceryVO
import com.mewz.grocery.network.FirebaseApi
import com.mewz.grocery.network.remoteconfig.FirebaseRemoteConfigManager

interface GroceryModel {

    var mFirebaseApi : FirebaseApi
    var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager
    fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFailure: (String) -> Unit)
    fun addGrocery(name: String ,description : String, amount: Int, image: String)
    fun removeGrocery(name: String)
    fun uploadImageAndUpdateGrocery(grocery : GroceryVO, image : Bitmap)

    fun setUpRemoteConfigWithDefaultValues()
    fun fetchRemoteConfigs()
    fun getAppNameFromRemoteConfig() : String
    fun getRecyclerViewLayoutNumber() : Long
}