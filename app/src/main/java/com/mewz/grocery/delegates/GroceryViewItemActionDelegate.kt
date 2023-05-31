package com.mewz.grocery.delegates

interface GroceryViewItemActionDelegate {
    fun onTapDeleteGrocery(name: String)
    fun onTapEditGrocery(name: String, description: String, amount: Int)
}