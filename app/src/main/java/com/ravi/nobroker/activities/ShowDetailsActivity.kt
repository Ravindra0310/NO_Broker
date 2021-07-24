package com.ravi.nobroker.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.ravi.nobroker.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_show_details.*

class ShowDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_details)
        setData()
    }

    private fun setData() {
        val photo=intent.getStringExtra("image")
        val title=intent.getStringExtra("title")
        val subtitle=intent.getStringExtra("subtitle")
        Glide.with(ivDetails).load(photo).into(ivDetails)
        tvTitleDetails.text=title
        tvSubTitle.text=subtitle
    }
}