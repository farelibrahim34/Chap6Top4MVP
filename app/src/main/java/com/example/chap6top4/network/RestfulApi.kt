package com.example.chap6top4.network

import com.example.chap6top4.model.DataCar
import com.example.chap6top4.model.ResponseDataCar
import com.example.chap6top4.model.ResponseDataCarItem
import retrofit2.Call
import retrofit2.http.*

interface RestfulApi {

    @GET("admin/car")
    fun getAllCar() : Call<List<ResponseDataCarItem>>

    @POST("admin/car")
    fun addDataCar(@Body request : DataCar) : Call<ResponseDataCar>

    @GET("admin/car")
    fun getDataByid(@Path("id") id : Int): Call<ResponseDataCarItem>

    @PUT("admin/car/{id}")
    fun updateDataCar(@Path("id") id : Int, @Body request : DataCar) : Call<List<ResponseDataCarItem>>

    @DELETE("admin/car/{id}")
    fun deleteDataCar(@Path("id") id : Int): Call<ResponseDataCarItem>
}