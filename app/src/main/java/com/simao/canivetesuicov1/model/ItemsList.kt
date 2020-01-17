package com.simao.canivetesuicov1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_list")
data class ItemsList (@ColumnInfo(name = "itemName") var itemName: String,
                      @ColumnInfo(name = "itemQtd") var itemQtd: Int,
                      @ColumnInfo(name= "itemPrice") var itemPrice: Double) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}