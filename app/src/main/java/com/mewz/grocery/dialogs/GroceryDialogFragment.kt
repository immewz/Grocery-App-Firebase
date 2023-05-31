package com.mewz.grocery.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.mewz.grocery.databinding.DialogAddGroceryBinding
import com.mewz.grocery.mvp.presenters.MainPresenter
import com.mewz.grocery.mvp.presenters.impls.MainPresenterImpl

class GroceryDialogFragment: DialogFragment() {

    private lateinit var binding: DialogAddGroceryBinding
    private lateinit var mPresenter: MainPresenter

    companion object {
        const val TAG_ADD_GROCERY_DIALOG = "TAG_ADD_GROCERY_DIALOG"
        const val BUNDLE_NAME = "BUNDLE_NAME"
        const val BUNDLE_DESCRIPTION = "BUNDLE_DESCRIPTION"
        const val BUNDLE_AMOUNT = "BUNDLE_AMOUNT"

        fun newFragment(): GroceryDialogFragment {
            return GroceryDialogFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // return super.onCreateView(inflater, container, savedInstanceState)

        binding = DialogAddGroceryBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()

        binding.etGroceryName.setText(arguments?.getString(BUNDLE_NAME))
        binding.etDescription.setText(arguments?.getString(BUNDLE_DESCRIPTION))
        binding.etAmount.setText(arguments?.getString(BUNDLE_AMOUNT))

        binding.btnAddGrocery.setOnClickListener {
            mPresenter.onTapAddGrocery(
                binding.etGroceryName.text.toString(),
                binding.etDescription.text.toString(),
                binding.etAmount.text.toString().toInt()
            )
            dismiss()
        }
    }

    private fun setUpPresenter() {
        activity?.let {
            mPresenter = ViewModelProviders.of(it).get(MainPresenterImpl::class.java)
        }
    }

}