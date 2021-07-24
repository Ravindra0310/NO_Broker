package com.ravi.nobroker.viewholder

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.guessmyage.Models.MyDataEntity
import com.ravi.nobroker.model.DataModelItem
import kotlinx.android.synthetic.main.item_layout.view.*

class ListViewHolder(private val view: View):RecyclerView.ViewHolder(view) {

    fun setData(dataModelItem: MyDataEntity){
        view.apply {
            Glide.with(ivAvatar).load(dataModelItem.image).into(ivAvatar)
            tvTitle.text=dataModelItem.title
            itemCard.setOnClickListener {

            }
        }
    }
}