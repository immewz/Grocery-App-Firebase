package com.mewz.grocery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mewz.grocery.R
import com.mewz.grocery.data.vos.GroceryVO
import com.mewz.grocery.delegates.GroceryViewItemActionDelegate
import com.mewz.grocery.viewholders.GroceryViewHolder

class GroceryAdapter(
    private val mDelegate: GroceryViewItemActionDelegate,
    private val number: Long
): BaseRecyclerAdapter<GroceryViewHolder, GroceryVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        return if (number == 0L){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_grocery_item,parent,false)
            return GroceryViewHolder(view, mDelegate)
        }else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_grocery_item_grid,parent,false)
            return GroceryViewHolder(view, mDelegate)
        }
    }
}