package com.ravi.nobroker.ApiCall

import com.ravi.nobroker.model.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("b/60fa8fefa917050205ce5470")
    suspend fun getResponse():DataModel
}