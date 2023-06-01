package com.mewz.grocery.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.mewz.grocery.data.models.AuthenticationModel
import com.mewz.grocery.data.models.AuthenticationModelImpl
import com.mewz.grocery.mvp.presenters.AbstractBasePresenter
import com.mewz.grocery.mvp.presenters.RegisterPresenter
import com.mewz.grocery.mvp.views.RegisterView

class RegisterPresenterImpl: RegisterPresenter, AbstractBasePresenter<RegisterView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapRegister(context : Context, email: String, password: String, userName: String) {
        if(email.isEmpty() || password.isEmpty() || userName.isEmpty()){
            mView.showError("Please enter all fields")
        } else {
            mAuthenticationModel.register(email, password, userName, onSuccess = {
                mView.navigateToToLoginScreen()
            }, onFailure = {
                mView.showError(it)
            })
        }
    }

    override fun onUiReady(
        context: Context,
        owner: LifecycleOwner
    ) {
    }
}