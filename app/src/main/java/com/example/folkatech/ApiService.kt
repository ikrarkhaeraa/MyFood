package com.example.folkatech

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("52c41978-6e31-4ea3-b917-01899e3ed373")
    fun getData(): Call<List<ResponseData>>
}