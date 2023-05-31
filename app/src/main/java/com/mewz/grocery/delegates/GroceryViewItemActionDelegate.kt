package com.mewz.grocery.delegates

import com.mewz.grocery.data.vos.GroceryVO

interface GroceryViewItemActionDelegate {
    fun onTapDeleteGrocery(name: String)
    fun onTapEditGrocery(name: String, description: String, amount: Int)
    fun onTapFileUpload(grocery: GroceryVO)
}