package com.ravi.nobroker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.guessmyage.Models.MyDataEntity
import com.ravi.nobroker.R
import com.ravi.nobroker.adapter.viewholder.ListViewHolder
import com.ravi.nobroker.adapter.viewholder.OnClickOfItem

class ListAdapter(
    private var dataList: MutableList<MyDataEntity>,
    var onClickOfItem: OnClickOfItem
) :
    RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ListViewHolder(view, onClickOfItem)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val list = dataList[position]
        holder.setData(list)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateList(modelList: List<MyDataEntity>) {
        dataList = modelList as MutableList<MyDataEntity>
        notifyDataSetChanged()
    }




}