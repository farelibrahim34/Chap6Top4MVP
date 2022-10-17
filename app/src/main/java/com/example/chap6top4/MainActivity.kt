package com.example.chap6top4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chap6top4.databinding.ActivityMainBinding
import com.example.chap6top4.model.ResponseDataCarItem
import com.example.chap6top4.presenter.CarPresenter
import com.example.chap6top4.presenter.CarView
import com.example.chap6top4.view.AdapterCar
import com.example.chap6top4.view.AddCarActivity

class MainActivity : AppCompatActivity(), CarView {
    lateinit var binding : ActivityMainBinding
    lateinit var presnter : CarPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presnter = CarPresenter(this)
        presnter.getDataCar()

        binding.addButton.setOnClickListener {
            var intent = Intent(this,AddCarActivity::class.java)
            startActivity(intent)
        }


    }


    override fun onSucces(pesan: String, car: List<ResponseDataCarItem>) {
        binding.rvCar.layoutManager = LinearLayoutManager(this)
        binding.rvCar.adapter = AdapterCar(car)
    }

    override fun onError(pesan: String){
        Toast.makeText(this,pesan,Toast.LENGTH_SHORT).show()
    }

}