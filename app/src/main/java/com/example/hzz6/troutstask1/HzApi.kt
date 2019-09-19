package com.example.hzz6.troutstask1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import com.google.gson.annotations.SerializedName
import retrofit2.Call


const val CLIENT_ID = "jJXGy7VHbKld3ZJDUFOw"
const val CLIENT_SECRET	 = "5R9RZ0tNNm"

const val BASE_URL = "https://openapi.naver.com/v1/"


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
    @Headers(
        "X-Naver-Client-Id: $CLIENT_ID",
        "X-Naver-Client-Secret: $CLIENT_SECRET"
    )
    @GET("search/movie.json")
    fun getNaverMovies(@Query("query") searchWord: String): Call<MoviesApi>
}



data class MoviesApi(
    @SerializedName("display")
    val display: Int,
    @SerializedName("items")
    val items: List<Movie>,
    @SerializedName("lastBuildDate")
    val lastBuildDate: String,
    @SerializedName("start")
    val start: Int,
    @SerializedName("total")
    val total: Int
)

data class Movie(
    @SerializedName("actor")
    val actor: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("pubDate")
    val pubDate: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("userRating")
    val userRating: String
)