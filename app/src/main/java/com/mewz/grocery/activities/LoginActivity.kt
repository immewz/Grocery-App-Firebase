package com.mewz.grocery.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdReceiver
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal
import com.mewz.grocery.databinding.ActivityLoginBinding
import com.mewz.grocery.mvp.presenters.LoginPresenter
import com.mewz.grocery.mvp.presenters.impls.LoginPresenterImpl
import com.mewz.grocery.mvp.views.LoginView

class LoginActivity : BaseActivity(), LoginView {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var mPresenter: LoginPresenter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpPresenter()
        setUpActionListeners()

        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
            Log.d("fbToken", it.token)
        }

        mPresenter.onUiReady(this, this)
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<LoginPresenterImpl, LoginView>()
    }

    private fun setUpActionListeners() {
        binding.btnLogin.setOnClickListener {
            mPresenter.onTapLogin(this, binding.etEmail.text.toString(), binding.etPassword.text.toString())
        }

        binding.btnRegister.setOnClickListener {
            mPresenter.onTapRegister()
        }
    }

    override fun navigateToHomeScreen() {
        startActivity(MainActivity.newIntent(this))
    }

    override fun navigateToRegisterScreen() {
        startActivity(RegisterActivity.newIntent(this))
    }
}