package com.mewz.grocery.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mewz.grocery.data.vos.GroceryVO
import com.mewz.grocery.databinding.ViewHolderGroceryItemBinding
import com.mewz.grocery.databinding.ViewHolderGroceryItemGridBinding
import com.mewz.grocery.delegates.GroceryViewItemActionDelegate

class GroceryViewHolder(itemView: View, private val mDelegate: GroceryViewItemActionDelegate)
    : BaseViewHolder<GroceryVO>(itemView) {

    private var binding: ViewHolderGroceryItemBinding

    init {
        binding = ViewHolderGroceryItemBinding.bind(itemView)
    }

    override fun bindData(data: GroceryVO) {
        binding.tvTitle.text = data.name
        binding.tvDescription.text = data.description
        binding.tvCount.text = "x ${data.amount.toString()}"

        binding.btnDelete.setOnClickListener {
            mDelegate.onTapDeleteGrocery(data.name ?: "")
        }

        binding.btnEdit.setOnClickListener {
            mDelegate.onTapEditGrocery(data.name ?: "", data.description ?: "", data.amount ?: 0)
        }

        binding.btnFileUpload.setOnClickListener {
            mDelegate.onTapFileUpload(data)
        }

        Glide.with(itemView.context)
            .load(data.image)
            .into(binding.ivGroceryImage)
    }
}