package com.simao.shoppingList.view.adapter

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.simao.shoppingList.R
import com.simao.shoppingList.model.ItemsList
import com.simao.shoppingList.viewmodel.ShoppingListViewModel
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter (private val itemList: List<ItemsList>?,
                   private val context: Context,
                   private val shoppingListViewModel: ShoppingListViewModel,
                   private val activity: Activity
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList?.get(position)

        item?.let { holder.bindView(it) }

        holder.deleteButton.setOnClickListener {
            item?.let { shoppingListViewModel.delete(it) }
        }

        holder.editButton.setOnClickListener {
            dialogBuilder(item)
        }
    }

    private fun dialogBuilder(item: ItemsList?) {
        AlertDialog.Builder(activity).apply {
            val dialogView = activity.layoutInflater.inflate(R.layout.update_list_dialog, null)
            val editNameField = dialogView.findViewById<EditText>(R.id.edit_name_field)
            val editQtdField = dialogView.findViewById<EditText>(R.id.edit_qtd_field)
            val editPriceField = dialogView.findViewById<EditText>(R.id.edit_price_field)

            setView(dialogView)

            setTitle("Edição de items")
            setMessage("Insira o Nome, Quantidade e Preço")
            setPositiveButton("Confirmar") {_, _ ->
                item?.itemName = editNameField.text.toString()
                item?.itemQtd = editQtdField.text.toString()
                item?.itemPrice = editPriceField.text.toString()

                item?.let { shoppingListViewModel.update(it) }
            }
            setNegativeButton("Cancelar", null)

        }.create().show()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val deleteButton: Button = itemView.delete_button
        val editButton: Button = itemView.edit_button

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