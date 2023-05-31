package com.mewz.grocery.network

import com.mewz.grocery.data.vos.GroceryVO

interface FirebaseApi {
    fun getGroceries(onSuccess: (groceries: List<GroceryVO>) -> Unit, onFailure: (String) -> Unit)
    fun addGrocery(name: String, description: String, amount: Int)
    fun deleteGrocery(name: String)
}