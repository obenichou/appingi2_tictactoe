package fr.epita.android.tictactoe

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.result.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Result : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)

        val data_r = ArrayList<History>()

        /* GET RETROFIT 2 -- BUG */
        val baseURL = "http://www.onzeweb.net/"
        val jsonConverter = GsonConverterFactory.create(GsonBuilder().create())
        val retrofitClient = Retrofit.Builder()
            .baseUrl(baseURL)!!
            .addConverterFactory(jsonConverter)
            .build()!!
        val service: WebServiceInterface = retrofitClient.create(WebServiceInterface::class.java)!!

        val callback = object : Callback<List<History>> {
            override fun onFailure(call: Call<List<History>>, t: Throwable) {
                Log.d("Connect API", "The Application Tic Tac Toe failed to contact the api")
                Log.d("Connect API", call.request().toString())
            }

            override fun onResponse(call: Call<List<History>>, response: Response<List<History>>) {
                Log.d("Connect API", response.message().toString())
            }
        }

        service.GetHistory().enqueue(callback)

        /* SET LAYOUT */
        activity_result_recycler_view.adapter = RecycleHistoryAdapter(data_r)
        activity_result_recycler_view.layoutManager = LinearLayoutManager(this@Result, LinearLayoutManager.VERTICAL, false)

    }
}