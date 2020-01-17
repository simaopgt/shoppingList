package com.simao.canivetesuicov1.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simao.canivetesuicov1.model.ItemsList
import com.simao.canivetesuicov1.repository.CaniveteRepositoryInterface
import kotlinx.coroutines.launch

class CaniveteViewModel (private val caniveteRepository: CaniveteRepositoryInterface) : ViewModel() {

    val allBooks : LiveData<List<ItemsList>> by lazy {
        caniveteRepository.allBooks()
    }

    fun insert (item : ItemsList) = viewModelScope.launch {
        caniveteRepository.insert(item)
    }

    fun delete (item : ItemsList) = viewModelScope.launch {
        caniveteRepository.delete(item)
    }

}