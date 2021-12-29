package com.smoothbear.app.network.dto

import com.google.gson.annotations.SerializedName

data class CocktailListResponse (
    @SerializedName("cocktails")
    val cocktails: List<CocktailListData>
)