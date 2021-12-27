package com.smoothbear.app.network.dto

import com.google.gson.annotations.SerializedName

data class CocktailResponse (
    @SerializedName("cocktails")
    val cocktails: List<CocktailData>
)