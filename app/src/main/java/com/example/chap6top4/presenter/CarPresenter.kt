package com.example.chap6top4.presenter

import com.example.chap6top4.model.DataCar
import com.example.chap6top4.model.ResponseDataCar
import com.example.chap6top4.model.ResponseDataCarItem
import com.example.chap6top4.network.RetrofitClien
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CarPresenter(val viewcar : CarView) {
    fun getDataCar(){
        RetrofitClien.instance.getAllCar()
            .enqueue(object : Callback<List<ResponseDataCarItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataCarItem>>,
                    response: Response<List<ResponseDataCarItem>>
                ) {
                    if (response.isSuccessful){
                        viewcar.onSucces(response.message(), response.body()!!)
                    }else{
                        viewcar.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {
                    viewcar.onError(t.message!!)
                }

            })
    }

    fun callPostApiCar(name : String, category : String, price : Int, status : Boolean, image : String){
        RetrofitClien.instance.addDataCar(DataCar(name, category, price, status, image))
            .enqueue(object : Callback<ResponseDataCar>{
                override fun onResponse(
                    call: Call<ResponseDataCar>,
                    response: Response<ResponseDataCar>
                ) {
                    if (response.isSuccessful){
                        viewcar.onSucces(response.message(), response.body()!!)
                    }else{
                        viewcar.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<ResponseDataCar>, t: Throwable) {
                    viewcar.onError(t.message!!)
                }

            })
    }
}