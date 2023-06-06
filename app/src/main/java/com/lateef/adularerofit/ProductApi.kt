package com.lateef.adularerofit


import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {

    //definding the endpoint
    @GET("/api/v1/products.json")
    fun getProductslist(): Call<List<ProdutdtoItem>>

}