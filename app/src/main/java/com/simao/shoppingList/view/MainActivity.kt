package com.simao.shoppingList.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.simao.shoppingList.R
import com.simao.shoppingList.model.ItemsList
import com.simao.shoppingList.view.adapter.ListAdapter
import com.simao.shoppingList.viewmodel.ShoppingListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.add_item_name_textView
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(){

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
            val itemsList = ItemsList(getItemName(), getItemQtd(), "False")
            shoppingListViewModel.insert(itemsList)
            resetFields()
            closeKeyboard()
        }
    }

    private fun resetFields() {
        add_item_name_textView.text.clear()
        add_item_qtd_textView.text.clear()
    }

    private fun closeKeyboard() {
        val view = this.currentFocus
        view?.let { v ->
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            inputMethodManager?.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }

    private fun createAdapter() = ListAdapter(shoppingListViewModel.allItems.value, this, shoppingListViewModel, this)

    private fun getItemName() : String {
        return add_item_name_textView.text.toString()
    }

    private fun getItemQtd() : String {
        return add_item_qtd_textView.text.toString()
    }
}
