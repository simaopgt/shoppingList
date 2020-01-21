package com.simao.canivetesuicov1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simao.canivetesuicov1.model.ItemsList
import com.simao.canivetesuicov1.repository.CaniveteRepositoryInterface
import kotlinx.coroutines.launch

class CaniveteViewModel (private val caniveteRepository: CaniveteRepositoryInterface) : ViewModel() {

    val allItems : LiveData<List<ItemsList>> by lazy {
        caniveteRepository.allBooks()
    }

    fun insert (item : ItemsList) = viewModelScope.launch {
        caniveteRepository.insert(item)
    }

    fun delete (item : ItemsList) = viewModelScope.launch {
        caniveteRepository.delete(item)
    }

    fun update (item: ItemsList) = viewModelScope.launch {
        caniveteRepository.update(item)
    }

}