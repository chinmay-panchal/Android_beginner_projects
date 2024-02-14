package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView : RecyclerView
    lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        myRecyclerView = findViewById(R.id.recyclerView)

        val newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
        )

        val newsHeadingArray = arrayOf(
            "All About Elon Musk's Neuralink And Its First Human Brain Implant",
            "India Drops To 5th In Maldives Tourism Rankings, Was No.1 In 2023",
            "David Warner Becomes First Australian To Make 100 Appearances In All Formats",
            "Crypto Price Today: Bitcoin Breaches $46,000 Mark, Most Cryptocurrencies Mint Profits",
            "Instagram Testing 'Flipside' Feature to Let Users Add an Alternative Account to Existing Profile",
            "Putin gives first western interview with Tucker Carlson"
        )

        val newsContent = arrayOf(
            getString(R.string.news_content_1), getString(R.string.news_content_2),
            getString(R.string.news_content_3), getString(R.string.news_content_4),
            getString(R.string.news_content_5), getString(R.string.news_content_6)
        )

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for( index in newsImageArray.indices){
            val news = News(newsHeadingArray[index], newsImageArray[index], newsContent[index])
            newsArrayList.add(news)
        }

        var myAdapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter

        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClicking(position: Int) {
                // on clicking each item , what action do you want to perform

                val intent = Intent(this@MainActivity, NewsDetailActivity::class.java)
                intent.putExtra("heading", newsArrayList[position].newsHeading)
                intent.putExtra("imageId", newsArrayList[position].newsImage)
                intent.putExtra("newscontent", newsArrayList[position].newsContent)
                startActivity(intent)
            }

        })

    }
}