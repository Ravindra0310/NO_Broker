package com.ravi.nobroker.ViewModel

import android.app.Application
import com.example.guessmyage.Models.MyDataDatabase
import com.ravi.nobroker.repository.ListRepository

class MyApplication:Application() {
    val MyDataDao by lazy {
        val roomDatabase= MyDataDatabase.getDatabase(this)
        roomDatabase.getMyAgeDao()
    }
    val repository by lazy {
        ListRepository(MyDataDao)
    }
}