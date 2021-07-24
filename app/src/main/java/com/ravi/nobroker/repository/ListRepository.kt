package com.ravi.nobroker.repository

import androidx.lifecycle.LiveData
import com.example.guessmyage.Models.MyDataDao
import com.example.guessmyage.Models.MyDataEntity
import com.ravi.nobroker.ApiCall.ApiClient
import com.ravi.nobroker.ApiCall.Network

import kotlinx.coroutines.flow.Flow

class ListRepository(val MyDataDaoObject: MyDataDao) {
    val apiClient = Network.getInstance().create(ApiClient::class.java)
    lateinit var myDataEntity: MyDataEntity

    /*
    getListOfModel is use to insert the retrofit response into RoomDatabase
     */
    suspend fun getListOfModel() {
        val resposne = apiClient.getResponse()
        for (i in resposne.indices) {
            myDataEntity =
                MyDataEntity(resposne.get(i).image, resposne.get(i).title, resposne.get(i).subTitle)
            MyDataDaoObject.insert(myDataEntity)
        }
        /*
      Once the response is fetched, navigate the user back to view model as this callback is being implemented
      in the ViewModel class
       */
    }

    /*
    get list is to get the list from room database
    */
    fun getlist(): LiveData<List<MyDataEntity>> {
        return MyDataDaoObject.getTask()
    }
    /*
    searchDatabase is use search the item from RoomDatabase
     */
    fun searchDatabase(searchQuery: String): Flow<List<MyDataEntity>> {
        return MyDataDaoObject.searchDatabase(searchQuery)
    }
}