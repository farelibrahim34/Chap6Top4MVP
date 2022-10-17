package com.example.chap6top4.presenter

import com.example.chap6top4.model.ResponseDataCarItem

interface CarView {
    fun onSucces(pesan : String, car : List<ResponseDataCarItem>)
    fun onError(pesan: String)
}