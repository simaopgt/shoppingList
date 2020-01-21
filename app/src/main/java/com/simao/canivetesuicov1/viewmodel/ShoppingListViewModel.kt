package com.simao.canivetesuicov1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simao.canivetesuicov1.model.ItemsList
import com.simao.canivetesuicov1.repository.ShoppingListRepositoryInterface
import kotlinx.coroutines.launch

class ShoppingListViewModel (private val shoppingListRepository: ShoppingListRepositoryInterface) : ViewModel() {

    val allItems : LiveData<List<ItemsList>> by lazy {
        shoppingListRepository.allBooks()
    }

    fun insert (item : ItemsList) = viewModelScope.launch {
        shoppingListRepository.insert(item)
    }

    fun delete (item : ItemsList) = viewModelScope.launch {
        shoppingListRepository.delete(item)
    }

    fun update (item: ItemsList) = viewModelScope.launch {
        shoppingListRepository.update(item)
    }

}