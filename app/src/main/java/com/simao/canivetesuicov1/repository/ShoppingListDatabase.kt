package com.simao.canivetesuicov1.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.simao.canivetesuicov1.model.ItemsList

@Database(entities = [ItemsList::class], version = 1)
abstract class ShoppingListDatabase: RoomDatabase() {
    abstract fun caniveteDao() : ShoppingListDAO
}