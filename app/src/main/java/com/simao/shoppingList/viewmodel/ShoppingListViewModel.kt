package com.simao.shoppingList.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simao.shoppingList.model.ItemsList
import com.simao.shoppingList.repository.ShoppingListRepositoryInterface
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