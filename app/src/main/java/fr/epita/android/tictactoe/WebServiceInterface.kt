package fr.epita.android.tictactoe

import retrofit2.Call
import retrofit2.http.GET

interface WebServiceInterface {
    @GET("api/scores.json")
    fun GetHistory(): Call<History>
}