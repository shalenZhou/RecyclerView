package com.example.recyclerviewbasicuse.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewbasicuse.R
import com.example.recyclerviewbasicuse.bean.Fruit

class FruitLandAdapter(private val fruitList: List<Fruit>) :
    RecyclerView.Adapter<FruitLandAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fruit_land_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = fruitList.size

    /*
        对RecyclerView子项的数据进行赋值，会在每个子项被滚动到屏幕内的时候执行
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name
    }

}