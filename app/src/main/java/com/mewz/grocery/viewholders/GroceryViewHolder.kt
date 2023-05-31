package com.mewz.grocery.viewholders

import android.view.View
import com.mewz.grocery.data.vos.GroceryVO
import com.mewz.grocery.databinding.ViewHolderGroceryItemBinding

class GroceryViewHolder(itemView: View)
    : BaseViewHolder<GroceryVO>(itemView) {

    private var binding: ViewHolderGroceryItemBinding

    init {
        binding = ViewHolderGroceryItemBinding.bind(itemView)
    }

    override fun bindData(data: GroceryVO) {
        binding.tvTitle.text = data.name
        binding.tvDescription.text = data.description
        binding.tvCount.text = "x ${data.amount.toString()}"
    }
}