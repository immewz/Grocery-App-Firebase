package com.mewz.grocery.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.mewz.grocery.analytics.PARAMETER_EMAIL
import com.mewz.grocery.analytics.SCREEN_LOGIN
import com.mewz.grocery.analytics.TAP_LOGIN
import com.mewz.grocery.data.models.AuthenticationModel
import com.mewz.grocery.data.models.AuthenticationModelImpl
import com.mewz.grocery.data.models.GroceryModel
import com.mewz.grocery.data.models.GroceryModelImpl
import com.mewz.grocery.mvp.presenters.AbstractBasePresenter
import com.mewz.grocery.mvp.presenters.LoginPresenter
import com.mewz.grocery.mvp.views.LoginView

class LoginPresenterImpl: LoginPresenter, AbstractBasePresenter<LoginView>() {

    private val mAuthenticatioModel: AuthenticationModel = AuthenticationModelImpl
    private val mGroceryModel: GroceryModel = GroceryModelImpl

    override fun onUiReady(
        context: Context,
        owner: LifecycleOwner
    ) {
        sendEventsToFirebaseAnalytics(context, SCREEN_LOGIN)
        mGroceryModel.setUpRemoteConfigWithDefaultValues()
        mGroceryModel.fetchRemoteConfigs()
    }

    override fun onTapLogin(context: Context, email: String, password: String) {
        if(email.isEmpty() || password.isEmpty()){
            mView.showError("Please enter all the fields")
        } else {
            sendEventsToFirebaseAnalytics(context, TAP_LOGIN, PARAMETER_EMAIL, email)
            mAuthenticatioModel.login(email, password, onSuccess = {
                mView.navigateToHomeScreen()
            }, onFailure = {
                mView.showError(it)
            })
        }
    }

    override fun onTapRegister() {
        mView.navigateToRegisterScreen()
    }
}