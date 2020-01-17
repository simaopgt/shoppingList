package com.simao.canivetesuicov1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.simao.canivetesuicov1.R
import com.simao.canivetesuicov1.model.ItemsList
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val caniveteViewModel : CaniveteViewModel by viewModel()

    private val TAG = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindAddItemToListButtom()

        caniveteViewModel.allBooks.observe(this, Observer { items ->
            Log.d(TAG, "ITEMS: $items")
        })
    }

    fun bindAddItemToListButtom() {
        insertButtom.setOnClickListener{
            caniveteViewModel.insert(ItemsList("Item 1", 1 , 20.0))
        }
    }

}
