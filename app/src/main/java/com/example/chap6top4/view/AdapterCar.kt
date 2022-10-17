package com.example.chap6top4.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chap6top4.databinding.ItemCarBinding
import com.example.chap6top4.model.ResponseDataCarItem

class AdapterCar(var listCar : List<ResponseDataCarItem>):RecyclerView.Adapter<AdapterCar.ViewHolder>() {
    class ViewHolder(var binding : ItemCarBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =ItemCarBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.nameCar.text = listCar[position].name
        holder.binding.categoryCar.text = listCar[position].category
        holder.binding.priceCar.text = listCar[position].price.toString()

        Glide.with(holder.itemView).load(listCar[position].image).into(holder.binding.imgCar)
    }

    override fun getItemCount(): Int {
        return listCar.size
    }
}