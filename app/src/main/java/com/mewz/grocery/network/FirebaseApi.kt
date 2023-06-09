package com.mewz.grocery.network

import android.graphics.Bitmap
import com.mewz.grocery.data.vos.GroceryVO

interface FirebaseApi {
    fun getGroceries(onSuccess: (groceries: List<GroceryVO>) -> Unit, onFailure: (String) -> Unit)
    fun addGrocery(name: String, description: String, amount: Int, image: String)
    fun deleteGrocery(name: String)
    fun uploadImageAndEditGrocery(image : Bitmap, grocery: GroceryVO)
}