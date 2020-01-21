package com.simao.canivetesuicov1.repository

import androidx.lifecycle.LiveData
import com.simao.canivetesuicov1.model.ItemsList

interface CaniveteRepositoryInterface {

    suspend fun insert (item: ItemsList)

    suspend fun delete (item: ItemsList)

    suspend fun update (item: ItemsList)

    fun allBooks() : LiveData<List<ItemsList>>

}