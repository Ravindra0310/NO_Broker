package com.ravi.nobroker.activities

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guessmyage.Models.MyDataDatabase
import com.example.guessmyage.Models.MyDataEntity
import com.ravi.nobroker.R
import com.ravi.nobroker.ViewModel.ListViewModel
import com.ravi.nobroker.ViewModel.ViewModelFactory
import com.ravi.nobroker.adapter.ListAdapter
import com.ravi.nobroker.adapter.viewholder.OnClickOfItem
import com.ravi.nobroker.repository.ListRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * This Activity makes an Api call and populates the result in a recycler view. This activity has
 * only UI related code
 */
class IteamListActivity : AppCompatActivity() ,OnClickOfItem{

    private lateinit var listViewModel: ListViewModel
    private lateinit var listAdapter: ListAdapter
    val dataModelList = mutableListOf<MyDataEntity>()


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val MyDataDao by lazy {
            val roomDatabase = MyDataDatabase.getDatabase(this)
            roomDatabase.getMyAgeDao()
        }
        val repository by lazy {
            ListRepository(MyDataDao)
        }

        val factory = ViewModelFactory(repository)
        listViewModel = ViewModelProvider(this, factory).get(ListViewModel::class.java)
        setRecyclerAdapter()


        if (isNetworkConnected()) {
            CoroutineScope(Dispatchers.IO).launch {
                listViewModel.insertData()
            }

            observeLiveData()
        }
        else if (!isNetworkConnected()) {
            observeLiveData()
        }

    }

    private fun observeLiveData() {
        shimmerFrameLayout.stopShimmer()
        shimmerFrameLayout.visibility = View.GONE
        recyclerviewList.visibility = View.VISIBLE
        listViewModel.getData().observe(this, Observer {
            dataModelList.clear()
            dataModelList.addAll(it)
            listAdapter.updateList(dataModelList)
        })
    }

    /**
     * Sets the recycler view adapter
     */
    private fun setRecyclerAdapter() {
        listAdapter = ListAdapter(dataModelList,this)
        val layoutManager = LinearLayoutManager(this)
            recyclerviewList.apply {
            this.layoutManager = layoutManager
            adapter = listAdapter
        }

    }

    override fun showDetails(dataModelItem: MyDataEntity, position: Int) {
        var intent=Intent(this,ShowDetailsActivity::class.java)
        intent.putExtra("image",dataModelItem.image)
        intent.putExtra("title",dataModelItem.title)
        intent.putExtra("subtitle",dataModelItem.subTitle)
        startActivity(intent)
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun isNetworkConnected(): Boolean {
        //1
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        //2
        val activeNetwork = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connectivityManager.activeNetwork
        } else {
            TODO("VERSION.SDK_INT < M")
        }
        //3
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        //4
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}