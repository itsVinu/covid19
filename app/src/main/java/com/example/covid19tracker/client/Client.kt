package com.example.covid19tracker.client

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {

    val gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)         //will convert every element in class as lower case with underscore
        .create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.covid19india.org/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val api = retrofit.create(
        getresults::class.java)

}
