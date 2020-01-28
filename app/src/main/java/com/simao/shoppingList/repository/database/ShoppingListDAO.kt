package com.simao.shoppingList.repository.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.simao.shoppingList.model.ItemsList

@Dao
interface ShoppingListDAO {

    @Query("SELECT * FROM item_list")
    fun getAll(): LiveData<List<ItemsList>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (vararg item : ItemsList)

    @Update
    suspend fun update (vararg item : ItemsList)

    @Delete
    suspend fun delete (item : ItemsList)

}