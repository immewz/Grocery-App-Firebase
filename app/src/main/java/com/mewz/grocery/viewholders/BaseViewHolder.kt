package com.mewz.grocery.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<W>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    protected var mData: W? = null
    abstract fun bindData(data: W)
}