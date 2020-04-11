package com.example.covid19tracker.client

import com.example.covid19tracker.totalresponse.IndiaCovidResponse
import retrofit2.Response
import retrofit2.http.GET


interface getresults {

    @GET("data.json")
    suspend fun getAllIndianCases():Response<IndiaCovidResponse>


}
