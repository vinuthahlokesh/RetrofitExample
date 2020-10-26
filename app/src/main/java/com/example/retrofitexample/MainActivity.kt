package com.example.retrofitexample

import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var data: List<DataClass>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val retro = RetrofitObject.getRetrofitInstance()
        val apiInterface = retro.create(RetrofitInterface::class.java)
        val objects: Call<List<DataClass>> = apiInterface.getdata()

        objects.enqueue(
            object : Callback<List<DataClass>> {
                override fun onResponse(
                    call: Call<List<DataClass>>,
                    response: Response<List<DataClass>>) {
                    val dataList: List<DataClass> = response.body()
                    recyclerView.adapter = RecyclerAdapter(dataList)
                }
                override fun onFailure(call: Call<List<DataClass>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_LONG).show()
                }
            })

    }

}









