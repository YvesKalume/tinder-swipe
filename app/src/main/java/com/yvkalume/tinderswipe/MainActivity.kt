package com.yvkalume.tinderswipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import com.yuyakaido.android.cardstackview.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CardStackListener {

    private lateinit var manager: CardStackLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mAdapter = ProfileAdapter()

        manager = CardStackLayoutManager(this,this).apply {
            setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
            setOverlayInterpolator(LinearInterpolator())
        }

        swipe_view.apply {
            layoutManager = manager
            adapter = mAdapter
        }

        mAdapter.submitList(getData())

        btn_heart.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            swipe_view.swipe()
        }

        btn_cancel.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            swipe_view.swipe()
        }
    }

    private fun getData(): ArrayList<Profile> {
        val profilesList = arrayListOf<Profile>()
        profilesList.add(Profile(1,"Yves Kalume","19 ans", R.drawable.profil1))
        profilesList.add(Profile(3,"Ada Lovelace","60 ans", R.drawable.images))
        profilesList.add(Profile(4,"Will Smith","30 ans", R.drawable.smith))
        profilesList.add(Profile(5,"First Crush","22 ans", R.drawable.images2))
        profilesList.add(Profile(6,"Ansu Fati","17 ans", R.drawable.fati))
        return profilesList
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun onCardSwiped(direction: Direction?) {

    }

    override fun onCardRewound() {

    }

    override fun onCardCanceled() {

    }

    override fun onCardAppeared(view: View?, position: Int) {

    }

    override fun onCardDisappeared(view: View?, position: Int) {

    }
}