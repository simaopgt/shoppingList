package com.simao.canivetesuicov1.repository

import androidx.lifecycle.LiveData
import com.simao.canivetesuicov1.model.ItemsList

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