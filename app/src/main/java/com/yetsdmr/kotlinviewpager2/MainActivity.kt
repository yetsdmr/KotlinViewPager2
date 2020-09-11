package com.yetsdmr.kotlinviewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var detailsList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postToList()

        viewPager2.adapter = ViewPagerAdapter(titlesList,detailsList,imagesList)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator : CircleIndicator3 = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewPager2)

        btnFakeSwipe.setOnClickListener {
            viewPager2.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }
        }

    }

    private fun addToList(title : String, detail : String, image : Int){
        titlesList.add(title)
        detailsList.add(detail)
        imagesList.add(image)

    }

    private fun postToList(){
        for (i : Int in 1..5){
            addToList("Title $i","Detail $i", R.mipmap.ic_launcher_round)
        }
    }
}