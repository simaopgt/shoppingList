package com.simao.canivetesuicov1.di

import androidx.room.Room
import com.simao.canivetesuicov1.repository.CaniveteDatabase
import com.simao.canivetesuicov1.repository.CaniveteRepository
import com.simao.canivetesuicov1.repository.CaniveteRepositoryInterface
import com.simao.canivetesuicov1.view.CaniveteViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val modules : Module = module {

//    Create Database
    single { Room.databaseBuilder(get(), CaniveteDatabase::class.java, "itemsList_database").build() }

//    Create BookDAO
    single { get<CaniveteDatabase>().caniveteDao() }

//    Create CaniveteRepository
    single <CaniveteRepositoryInterface> {CaniveteRepository(get()) }

//    Create CaniveteViewModel
     viewModel { CaniveteViewModel(get()) }

}