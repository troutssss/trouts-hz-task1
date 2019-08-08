package com.example.hzz6.troutstask1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val CLIENT_ID = "jJXGy7VHbKld3ZJDUFOw"
const val CLIENT_SECRET	 = "5R9RZ0tNNm"

const val BASE_URL = "https://openapi.naver.com/v1"


object HzApi {
    val troutsService: TroutsService

    init {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        troutsService = retrofit.create(TroutsService::class.java)
    }

}

interface TroutsService {
    @Headers("CLIENT_ID :  $CLIENT_ID ," +
            "CLIENT_SECRET : $CLIENT_SECRET ")
    @GET("/search/movie.json")
    fun getNaverMovies(@Query("query") searchWord: String)
}