package com.simao.shoppingList.model

import com.google.gson.annotations.SerializedName

data class CatFunFactAPIResponse (@SerializedName("all") val all : List<FunFact>)