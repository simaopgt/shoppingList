package com.simao.shoppingList.di

import androidx.room.Room
import com.simao.shoppingList.repository.ShoppingListDatabase
import com.simao.shoppingList.repository.ShoppingListRepository
import com.simao.shoppingList.repository.ShoppingListRepositoryInterface
import com.simao.shoppingList.viewmodel.ShoppingListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val modules : Module = module {

//    Create Database
    single { Room.databaseBuilder(get(), ShoppingListDatabase::class.java, "itemsList_database").build() }

//    Create BookDAO
    single { get<ShoppingListDatabase>().shoppingListDAO() }

//    Create ShoppingListRepository
    single <ShoppingListRepositoryInterface> {ShoppingListRepository(get()) }

//    Create ShoppingListViewModel
     viewModel { ShoppingListViewModel(get()) }

}