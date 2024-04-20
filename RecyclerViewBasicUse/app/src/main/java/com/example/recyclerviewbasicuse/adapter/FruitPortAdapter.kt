package com.example.recyclerviewbasicuse.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewbasicuse.R
import com.example.recyclerviewbasicuse.bean.Fruit

private const val TAG = "FruitPortAdapter"

class FruitPortAdapter(private val fruitList: List<Fruit>) :
    RecyclerView.Adapter<FruitPortAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fruit_port_item, parent, false)
        val holder = ViewHolder(view)

        Log.d(TAG, "position: ${holder.bindingAdapterPosition}") // -1

        holder.itemView.setOnClickListener {
            /*
                holder.bindingAdapterPosition 一定要放在监听函数里面，毕竟只有ViewHolder创建出来，才能确定其位置
             */
            Log.d(TAG, "position: ${holder.bindingAdapterPosition}")

            val fruit = fruitList[holder.bindingAdapterPosition]
            Toast.makeText(
                holder.itemView.context,
                "You clicked view ${fruit.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.fruitImage.setOnClickListener {
            val fruit = fruitList[holder.bindingAdapterPosition]
            Toast.makeText(
                holder.itemView.context,
                "You clicked image ${fruit.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
        return holder
    }

    override fun getItemCount(): Int = fruitList.size

    /*
        对RecyclerView子项的数据进行赋值，会在每个子项被滚动到屏幕内的时候执行
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[holder.bindingAdapterPosition]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name
    }

}