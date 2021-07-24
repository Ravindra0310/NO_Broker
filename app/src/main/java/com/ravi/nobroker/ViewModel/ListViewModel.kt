package com.ravi.nobroker.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guessmyage.Models.MyDataEntity
import com.ravi.nobroker.model.DataModel
import com.ravi.nobroker.repository.ListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

/**
 * This is a VM layer in the `MVVM` architecture, where we are notifying the Activity/view about the
 * response changes via live data
 */

class ListViewModel(val respository: ListRepository) : ViewModel() {

//    private val repository = ListRepository(this)
//
//    private val mutableLiveData= MutableLiveData<DataModel>()
//
//    val liveData: LiveData<DataModel> = mutableLiveData
//    /**
//     * This method is called once the response is received from the API
//     */
//    override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
//
//        response.body()?.let {
//            mutableLiveData.value=it
//        }
//    }
//    /**
//     * If the API response fails due to some reason this method gets invoked
//     */
//    override fun onFailure(call: Call<DataModel>, t: Throwable) {
//
//    }
//    /**
//     * This method makes an API call to the Repository class where actual API call is made
//     */
//    fun callAPI() {
//        CoroutineScope(Dispatchers.IO).launch {
//            repository.getListOfModel()
//        }
//    }
//}

    fun getData(): LiveData<List<MyDataEntity>> {
        return respository.getlist()
    }

    fun insertData() {
        CoroutineScope(Dispatchers.IO).launch {
            respository.getListOfModel()
        }
    }
}