package com.ravi.nobroker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.guessmyage.Models.MyDataEntity
import com.ravi.nobroker.R
import com.ravi.nobroker.model.DataModelItem
import com.ravi.nobroker.viewholder.ListViewHolder

class ListAdapter(private var dataList:  List<MyDataEntity>):
    RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
val list=dataList[position]
        holder.setData(list)
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    fun updateList(modelList: List<MyDataEntity>){
        dataList = modelList
        notifyDataSetChanged()
    }


}