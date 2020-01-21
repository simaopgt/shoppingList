package com.simao.shoppingList.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_list")
data class ItemsList (@ColumnInfo(name = "itemName") var itemName: String,
                      @ColumnInfo(name = "itemQtd") var itemQtd: String,
                      @ColumnInfo(name = "isChecked") var isChecked: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}