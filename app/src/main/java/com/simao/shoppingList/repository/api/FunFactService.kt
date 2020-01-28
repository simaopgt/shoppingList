package com.simao.shoppingList.repository.api

import com.simao.shoppingList.model.CatFunFactAPIResponse
import retrofit2.http.GET

interface FunFactService {

    @GET ("facts")
    suspend fun list(): CatFunFactAPIResponse

}