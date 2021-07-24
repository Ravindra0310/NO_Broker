package com.ravi.nobroker.model


import com.google.gson.annotations.SerializedName

data class DataModelItem(
    @SerializedName("image")
    var image: String,
    @SerializedName("subTitle")
    var subTitle: String,
    @SerializedName("title")
    var title: String
)