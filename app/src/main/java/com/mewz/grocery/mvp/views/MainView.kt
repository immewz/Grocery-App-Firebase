package com.mewz.grocery.mvp.views

import com.mewz.grocery.data.vos.GroceryVO

interface MainView: BaseView {

    fun showGroceryData(groceryList: List<GroceryVO>)
}