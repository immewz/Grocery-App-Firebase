package com.mewz.grocery.data.models

import com.mewz.grocery.data.vos.GroceryVO
import com.mewz.grocery.network.FirebaseApi
import com.mewz.grocery.network.RealtimeDatabaseFirebaseApiImpl

object GroceryModelImpl: GroceryModel {

    override var mFirebaseApi: FirebaseApi = RealtimeDatabaseFirebaseApiImpl

    override fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getGroceries(onSuccess, onFailure)
    }

    override fun addGrocery(name: String, description: String, amount: Int) {
        mFirebaseApi.addGrocery(name, description, amount)
    }
}