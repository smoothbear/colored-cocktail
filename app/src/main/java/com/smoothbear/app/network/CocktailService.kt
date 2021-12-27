package com.smoothbear.app.network

import com.smoothbear.app.network.dto.CocktailData
import com.smoothbear.app.network.dto.CocktailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CocktailService {

    @GET("cocktail")
    suspend fun getCocktailList(@Query("page") page: Int): CocktailResponse

    @GET("cocktail/{id}")
    suspend fun getCocktailById(@Path("id") id: Int): CocktailData

}