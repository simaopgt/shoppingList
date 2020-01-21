package com.simao.canivetesuicov1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.simao.canivetesuicov1.R
import com.simao.canivetesuicov1.model.ItemsList
import com.simao.canivetesuicov1.view.adapter.ListAdapter
import com.simao.canivetesuicov1.viewmodel.ShoppingListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.add_item_name_textView
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val shoppingListViewModel : ShoppingListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = main_list_recycler_view

        recyclerView.adapter = createAdapter()

        bindAddItemToListButton()

        observeItemList(recyclerView)
    }

    private fun observeItemList(recyclerView: RecyclerView) {
        shoppingListViewModel.allItems.observe(this, Observer {
            recyclerView.adapter = createAdapter()
        })
    }

    private fun bindAddItemToListButton() {
        add_button.setOnClickListener{
            val itemsList = ItemsList(getItemName(), getItemQtd() , getItemPrice())
            shoppingListViewModel.insert(itemsList)
        }
    }

    private fun createAdapter() = ListAdapter(shoppingListViewModel.allItems.value, this, shoppingListViewModel, this)

    private fun getItemName() : String {
        return add_item_name_textView.text.toString()
    }

    private fun getItemQtd() : String {
        return add_item_qtd_textView.text.toString()
    }

    private fun getItemPrice() : String {
        return add_item_price_textView.text.toString()
    }
}
