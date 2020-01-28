package com.simao.shoppingList.di

import androidx.room.Room
import com.simao.shoppingList.repository.database.ShoppingListDatabase
import com.simao.shoppingList.repository.ShoppingListRepository
import com.simao.shoppingList.repository.ShoppingListRepositoryInterface
import com.simao.shoppingList.repository.api.FunFactService
import com.simao.shoppingList.viewmodel.ShoppingListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val modules : Module = module {

//    Create Database
    single { Room.databaseBuilder(get(), ShoppingListDatabase::class.java, "itemsList_database").build() }

//    Create BookDAO
    single { get<ShoppingListDatabase>().shoppingListDAO() }

//    Create ShoppingListRepository
    single <ShoppingListRepositoryInterface> {ShoppingListRepository(get(), get()) }

//    Create ShoppingListViewModel
    viewModel { ShoppingListViewModel(get()) }

    single { provideRetrofit() }

    factory { provideCatFunApi(get()) }

}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://cat-fact.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideCatFunApi(retrofit: Retrofit) : FunFactService {
    return retrofit.create(FunFactService::class.java)
}