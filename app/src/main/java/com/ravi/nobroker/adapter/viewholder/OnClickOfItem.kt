package com.ravi.nobroker.adapter.viewholder

import com.example.guessmyage.Models.MyDataEntity

interface OnClickOfItem {

    fun showDetails(dataModelItem: MyDataEntity,position:Int)
}