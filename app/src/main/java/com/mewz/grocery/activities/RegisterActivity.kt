package com.mewz.grocery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mewz.grocery.R
import com.mewz.grocery.databinding.ActivityRegisterBinding
import com.mewz.grocery.mvp.presenters.RegisterPresenter
import com.mewz.grocery.mvp.presenters.impls.RegisterPresenterImpl
import com.mewz.grocery.mvp.views.RegisterView

class RegisterActivity : BaseActivity(), RegisterView {

    private lateinit var binding: ActivityRegisterBinding

    private lateinit var mPresenter: RegisterPresenter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpPresenter()
        setUpActionListeners()
        mPresenter.onUiReady(this, this)
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<RegisterPresenterImpl, RegisterView>()
    }

    private fun setUpActionListeners() {
        binding.btnRegister.setOnClickListener {
            mPresenter.onTapRegister(
                this,
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString(),
                binding.etUserName.text.toString()
            )
        }
    }

    override fun navigateToToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
    }
}