package com.simao.canivetesuicov1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.simao.canivetesuicov1.R
import com.simao.canivetesuicov1.model.ItemsList
import com.simao.canivetesuicov1.view.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val caniveteViewModel : CaniveteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = main_list_recycler_view

        recyclerView.adapter = getItemList()

        bindAddItemToListButtom()

        observeItemList(recyclerView)
    }

    private fun observeItemList(recyclerView: RecyclerView) {
        caniveteViewModel.allItems.observe(this, Observer {
            recyclerView.adapter = getItemList()
        })
    }

    private fun bindAddItemToListButtom() {
        add_button.setOnClickListener{
            caniveteViewModel.insert(ItemsList(getItemName(), getItemQtd() , getItemPrice()))
        }
    }

    private fun getItemList() :ListAdapter {
        return ListAdapter(caniveteViewModel.allItems.value, this)
    }

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
