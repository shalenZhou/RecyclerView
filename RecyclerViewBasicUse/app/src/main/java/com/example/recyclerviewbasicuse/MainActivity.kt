package com.example.recyclerviewbasicuse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewbasicuse.adapter.FruitPortAdapter
import com.example.recyclerviewbasicuse.bean.Fruit
import com.example.recyclerviewbasicuse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 纵向滚动
        initFruits()
        val portLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = portLayoutManager
        val portAdapter = FruitPortAdapter(fruitList)
        binding.recyclerView.adapter = portAdapter

        // 横向滚动
//        initFruits()
//        val landLayoutManager = LinearLayoutManager(this)
//        landLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
//        binding.recyclerView.layoutManager = landLayoutManager
//        val landAdapter = FruitLandAdapter(fruitList)
//        binding.recyclerView.adapter = landAdapter

        // 瀑布流
//        initMoreFruits()
//        val flowLayoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
//        binding.recyclerView.layoutManager = flowLayoutManager
//        val adapter = FruitFlowAdapter(fruitList)
//        binding.recyclerView.adapter = adapter
    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(Fruit("Apple", R.drawable.apple_pic))
            fruitList.add(Fruit("Banana", R.drawable.banana_pic))
            fruitList.add(Fruit("Orange", R.drawable.orange_pic))
            fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruit("Pear", R.drawable.pear_pic))
            fruitList.add(Fruit("Grape", R.drawable.grape_pic))
            fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
            fruitList.add(Fruit("Mango", R.drawable.mango_pic))
        }
    }

    private fun initMoreFruits() {
        repeat(5) {
            fruitList.add(Fruit(getRandomLengthString("Apple"), R.drawable.apple_pic))
            fruitList.add(Fruit(getRandomLengthString("Banana"), R.drawable.banana_pic))
            fruitList.add(Fruit(getRandomLengthString("Orange"), R.drawable.orange_pic))
            fruitList.add(Fruit(getRandomLengthString("Watermelon"), R.drawable.watermelon_pic))
            fruitList.add(Fruit(getRandomLengthString("Pear"), R.drawable.pear_pic))
            fruitList.add(Fruit(getRandomLengthString("Grape"), R.drawable.grape_pic))
            fruitList.add(Fruit(getRandomLengthString("Pineapple"), R.drawable.pineapple_pic))
            fruitList.add(Fruit(getRandomLengthString("Strawberry"), R.drawable.strawberry_pic))
            fruitList.add(Fruit(getRandomLengthString("Cherry"), R.drawable.cherry_pic))
            fruitList.add(Fruit(getRandomLengthString("Mango"), R.drawable.mango_pic))
        }
    }

    private fun getRandomLengthString(string: String): String {
        val n = (1..10).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(string)
        }
        return builder.toString()
    }
}