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
import androidx.lifecycle.asLiveData
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

/**
 * This is a VM layer in the `MVVM` architecture, where we are notifying the Activity/view about the
 * response changes via live data
 */

class ListViewModel (val repository: ListRepository) : ViewModel() {

    fun getData(): LiveData<List<MyDataEntity>> {
        return repository.getlist()
    }

    fun insertData() {
        CoroutineScope(Dispatchers.IO).launch {
            repository.getListOfModel()
        }
    }

    fun searchDatabase(searchQuery: String): LiveData<List<MyDataEntity>> {
        return repository.searchDatabase(searchQuery).asLiveData()
    }
}