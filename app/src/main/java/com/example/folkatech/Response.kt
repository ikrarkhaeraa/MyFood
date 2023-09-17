package com.example.folkatech

import com.google.gson.annotations.SerializedName


//data class Response (
//    @field:SerializedName("")
//    val data: List<ListProduct>
//)
//
data class ResponseData(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("cover")
    val cover: String,

    @field:SerializedName("desc")
    val desc: String,

    @field:SerializedName("price")
    val price: Int
)
