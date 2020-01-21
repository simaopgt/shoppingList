package com.simao.shoppingList.repository

import androidx.lifecycle.LiveData
import com.simao.shoppingList.model.ItemsList

interface ShoppingListRepositoryInterface {

    suspend fun insert (item: ItemsList)

    suspend fun delete (item: ItemsList)

    suspend fun update (item: ItemsList)

    fun allBooks() : LiveData<List<ItemsList>>

}