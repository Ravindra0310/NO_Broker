package com.ravi.nobroker.repository

import androidx.lifecycle.LiveData
import com.example.guessmyage.Models.MyDataDao
import com.example.guessmyage.Models.MyDataEntity
import com.example.itunesusingmvvm.Models.Netrork.API.Resource
import com.example.itunesusingmvvm.Models.Netrork.API.ResponseHandler
import com.ravi.nobroker.ApiCall.ApiClient
import com.ravi.nobroker.ApiCall.Network
import com.ravi.nobroker.model.DataModel
import retrofit2.Call
import retrofit2.Callback


class ListRepository(val MyDataDaoObject:MyDataDao) {
    val apiClient=Network.getInstance().create(ApiClient::class.java)
    val responseHandler = ResponseHandler()
    lateinit var myDataEntity : MyDataEntity

    suspend fun getListOfModel(){
            val resposne=apiClient.getResponse()
            for(i in resposne.indices){
                 myDataEntity = MyDataEntity(resposne.get(i).image,resposne.get(i).title,resposne.get(i).subTitle)
                MyDataDaoObject.insert(myDataEntity)
            }

        /*
      Once the response is fetched, navigate the user back to view model as this callback is being implemented
      in the Viewmodel class
       */
    }

    fun getlist(): LiveData<List<MyDataEntity>> {
        return MyDataDaoObject.getTask()
    }
}