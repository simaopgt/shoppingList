package com.simao.canivetesuicov1.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.simao.canivetesuicov1.R
import com.simao.canivetesuicov1.model.ItemsList
import com.simao.canivetesuicov1.view.CaniveteViewModel
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter (private val itemList: List<ItemsList>?,
                   private val context: Context,
                   private val caniveteViewModel: CaniveteViewModel) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (itemList != null) {
            return itemList.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList?.get(position)

        if (item != null) {
            holder.bindView(item)
        }

        holder.deleteButton.setOnClickListener {
            if (item != null) {
                caniveteViewModel.delete(item)
            }
            itemList?.toMutableList()?.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemList!!.size)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val deleteButton: Button = itemView.delete_button

        fun bindView(item: ItemsList){
            val itemName = itemView.add_item_name_textView
            val itemQtd = itemView.item_qtd_textView
            val itemPrice = itemView.item_price_textView

            itemName.text = item.itemName
            itemQtd.text = item.itemQtd
            itemPrice.text = item.itemPrice
        }

    }

}