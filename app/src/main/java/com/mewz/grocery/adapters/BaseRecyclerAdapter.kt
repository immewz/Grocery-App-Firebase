package com.mewz.grocery.adapters

import androidx.recyclerview.widget.RecyclerView
import com.mewz.grocery.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<T : BaseViewHolder<W>, W> : RecyclerView.Adapter<T>() {

    protected var mData: ArrayList<W> = arrayListOf()

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setNewData(newData: List<W>) {
        if (newData.isEmpty()){
            mData.clear()
        }else{
            mData = ArrayList(newData)
        }
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): W? {
        return if (position < mData.size) mData[position] else null
    }

    fun getItems(): List<W> {
        return mData
    }

    fun clearData() {
        mData = arrayListOf()
        notifyDataSetChanged()
    }
}