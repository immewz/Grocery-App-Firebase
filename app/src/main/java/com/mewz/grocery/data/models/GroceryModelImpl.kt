package com.mewz.grocery.data.models

import android.graphics.Bitmap
import com.mewz.grocery.data.vos.GroceryVO
import com.mewz.grocery.network.CloudFirestoreFirebaseApiImpl
import com.mewz.grocery.network.FirebaseApi
import com.mewz.grocery.network.RealtimeDatabaseFirebaseApiImpl

object GroceryModelImpl: GroceryModel {

    override var mFirebaseApi: FirebaseApi = RealtimeDatabaseFirebaseApiImpl
//    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

    override fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getGroceries(onSuccess, onFailure)
    }

    override fun addGrocery(name: String, description: String, amount: Int, image: String) {
        mFirebaseApi.addGrocery(name, description, amount, image)
    }

    override fun removeGrocery(name: String) {
        mFirebaseApi.deleteGrocery(name)
    }

    override fun uploadImageAndUpdateGrocery(grocery: GroceryVO, image: Bitmap) {
        mFirebaseApi.uploadImageAndEditGrocery(image, grocery)
    }
}