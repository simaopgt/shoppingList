package com.simao.shoppingList.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.simao.shoppingList.model.ItemsList

@Database(entities = [ItemsList::class], version = 1)
abstract class ShoppingListDatabase: RoomDatabase() {
    abstract fun shoppingListDAO() : ShoppingListDAO
}