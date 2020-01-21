package com.simao.canivetesuicov1.di

import androidx.room.Room
import com.simao.canivetesuicov1.repository.ShoppingListDatabase
import com.simao.canivetesuicov1.repository.ShoppingListRepository
import com.simao.canivetesuicov1.repository.ShoppingListRepositoryInterface
import com.simao.canivetesuicov1.viewmodel.ShoppingListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val modules : Module = module {

//    Create Database
    single { Room.databaseBuilder(get(), ShoppingListDatabase::class.java, "itemsList_database").build() }

//    Create BookDAO
    single { get<ShoppingListDatabase>().caniveteDao() }

//    Create ShoppingListRepository
    single <ShoppingListRepositoryInterface> {ShoppingListRepository(get()) }

//    Create ShoppingListViewModel
     viewModel { ShoppingListViewModel(get()) }

}