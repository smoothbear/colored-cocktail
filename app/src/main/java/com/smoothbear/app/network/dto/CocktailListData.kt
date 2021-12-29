package com.smoothbear.app.network.dto

import com.google.gson.annotations.SerializedName

data class CocktailListData (

    @SerializedName("id")
    var id: Int,

    @SerializedName("image-url")
    var imageUrl: String,

    @SerializedName("title")
    var title: String

)
