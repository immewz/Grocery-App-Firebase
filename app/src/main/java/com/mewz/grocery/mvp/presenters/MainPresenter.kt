package com.mewz.grocery.mvp.presenters

import android.graphics.Bitmap
import com.mewz.grocery.delegates.GroceryViewItemActionDelegate
import com.mewz.grocery.mvp.views.MainView

interface MainPresenter: BasePresenter<MainView>, GroceryViewItemActionDelegate {
    fun onTapAddGrocery(name: String, description: String, amount: Int)
    fun onPhotoTaken(bitmap: Bitmap)
}