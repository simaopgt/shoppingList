package com.simao.canivetesuicov1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.simao.canivetesuicov1.R
import com.simao.canivetesuicov1.model.ItemsList
import com.simao.canivetesuicov1.view.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.add_item_name_textView
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val caniveteViewModel : CaniveteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = main_list_recycler_view

        recyclerView.adapter = createAdapter()

        bindAddItemToListButton()

        observeItemList(recyclerView)
    }

    private fun observeItemList(recyclerView: RecyclerView) {
        caniveteViewModel.allItems.observe(this, Observer {
            recyclerView.adapter = createAdapter()
        })
    }

    private fun bindAddItemToListButton() {
        add_button.setOnClickListener{
            val itemsList = ItemsList(getItemName(), getItemQtd() , getItemPrice())
            caniveteViewModel.insert(itemsList)
        }
    }

    private fun createAdapter() :ListAdapter {
        return ListAdapter(caniveteViewModel.allItems.value, this, caniveteViewModel)
    }

    private fun getItemName() : String {
        return if (add_item_name_textView.text.toString() == ""){
            ""
        } else add_item_name_textView.text.toString()
    }

    private fun getItemQtd() : String {
        return if (add_item_qtd_textView.text.toString() == ""){
            ""
        } else add_item_qtd_textView.text.toString()
    }

    private fun getItemPrice() : String {
        return if (add_item_price_textView.text.toString() == ""){
            ""
        } else add_item_price_textView.text.toString()
    }

}
