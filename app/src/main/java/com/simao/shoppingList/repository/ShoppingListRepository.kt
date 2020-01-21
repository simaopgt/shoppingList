package com.simao.shoppingList.repository

import androidx.lifecycle.LiveData
import com.simao.shoppingList.model.ItemsList

class ShoppingListRepository(private val shoppingListDao: ShoppingListDAO) : ShoppingListRepositoryInterface {
    override suspend fun insert (item: ItemsList) {
        shoppingListDao.insert(item)
    }

    override fun allBooks(): LiveData<List<ItemsList>> {
        return shoppingListDao.getAll()
    }

    override suspend fun update(item: ItemsList) {
        shoppingListDao.update(item)
    }

    override suspend fun delete(item: ItemsList) {
        shoppingListDao.delete(item)
    }
}