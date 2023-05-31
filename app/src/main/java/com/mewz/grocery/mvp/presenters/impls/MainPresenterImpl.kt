package com.mewz.grocery.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.mewz.grocery.data.models.GroceryModelImpl
import com.mewz.grocery.mvp.presenters.AbstractBasePresenter
import com.mewz.grocery.mvp.presenters.MainPresenter
import com.mewz.grocery.mvp.views.MainView

class MainPresenterImpl: MainPresenter, AbstractBasePresenter<MainView>() {

    val mGroceryModel = GroceryModelImpl
    override fun onTapAddGrocery(name: String, description: String, amount: Int) {
        mGroceryModel.addGrocery(name, description, amount)
    }

    override fun onUiReady(context: Context, owner: LifecycleOwner) {
        mGroceryModel.getGroceries(
            onSuccess = {
                mView.showGroceryData(it)
            },
            onFailure = {
                mView.showError(it)
            }
        )
    }
}