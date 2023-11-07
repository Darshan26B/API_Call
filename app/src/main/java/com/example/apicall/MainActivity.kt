package com.example.apicall

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apicall.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: API_Adapter
    var Datalist = ArrayList<UserModelItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

                    binding.RecycleApi.layoutManager = LinearLayoutManager(this@MainActivity)
        APICALL()

    }

    private fun APICALL() {
        var api = API_Client.getretrofit()?.create(Api_Interface::class.java)

        api?.getApiretrofit()?.enqueue(object : retrofit2.Callback<UserModelItem> {
            override fun onResponse(call: Call<UserModelItem>, response: Response<UserModelItem>) {

                    var DataList = response.body()
                    Datalist.addAll(DataList as  ArrayList<UserModelItem>)

                    adapter.setData(Datalist)
                    binding.RecycleApi.adapter = adapter



            }

            override fun onFailure(call: Call<UserModelItem>, t: Throwable) {

                d  ("MainActivity","OnFailure: " +t.message)

                }

        })
    }

}

private fun Any?.enqueue(callback: retrofit2.Callback<UserModelItem>) {


}




