package com.simao.shoppingList.repository

import androidx.lifecycle.LiveData
import com.simao.shoppingList.model.CatFunFactAPIResponse
import com.simao.shoppingList.model.ItemsList
import com.simao.shoppingList.repository.api.FunFactService
import com.simao.shoppingList.repository.database.ShoppingListDAO

class ShoppingListRepository(private val shoppingListDao: ShoppingListDAO, private val funFactService: FunFactService) : ShoppingListRepositoryInterface {
    override fun allBooks(): LiveData<List<ItemsList>> {
        return shoppingListDao.getAll()
    }

    override suspend fun insert (item: ItemsList) {
        shoppingListDao.insert(item)
    }

    override suspend fun update(item: ItemsList) {
        shoppingListDao.update(item)
    }

    override suspend fun delete(item: ItemsList) {
        shoppingListDao.delete(item)
    }

    override suspend fun getAllFacts(): CatFunFactAPIResponse {
        return funFactService.list()
    }
}