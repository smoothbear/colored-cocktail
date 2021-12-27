package com.smoothbear.app.network.dto

import com.google.gson.annotations.SerializedName

data class CocktailData (

    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("location")
    var location: String,

    @SerializedName("price")
    var price: Int,

    @SerializedName("image_url")
    var imageUrl: String

)
