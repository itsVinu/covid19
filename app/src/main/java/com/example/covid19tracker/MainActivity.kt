package com.example.covid19tracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19tracker.client.Client
import com.example.covid19tracker.totalresponse.StatewiseItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val list = arrayListOf<StatewiseItem>()
    val countryadapter = CountryAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)


        mainRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,RecyclerView.VERTICAL,false)
            adapter = countryadapter
        }

        countryadapter.onItemClick = {
            Toast.makeText(this@MainActivity,"country",Toast.LENGTH_SHORT).show()
        }

        GlobalScope.launch {
            val response = withContext(Dispatchers.IO){Client.api.getAllIndianCases()}
            if (response.isSuccessful){
                response.body()?.let { res->
                    res.statewise?.let {
                        list.addAll(it) }
                    runOnUiThread{countryadapter.notifyDataSetChanged()}
                }
            }
        }

    }

}
