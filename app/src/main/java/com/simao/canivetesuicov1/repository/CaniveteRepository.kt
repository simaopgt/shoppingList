package com.simao.canivetesuicov1.repository

import androidx.lifecycle.LiveData
import com.simao.canivetesuicov1.model.ItemsList

class CaniveteRepository(private val caniveteDao: CaniveteDAO) : CaniveteRepositoryInterface {

    override suspend fun insert (item: ItemsList) {
        caniveteDao.insert(item)
    }

    override fun allBooks(): LiveData<List<ItemsList>> {
        return caniveteDao.getAll()
    }

    override suspend fun update(item: ItemsList) {
        caniveteDao.update(item)
    }

    override suspend fun delete(item: ItemsList) {
        caniveteDao.delete(item)
    }

}