package com.example.hzz6.troutstask1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.hzz6.troutstask1.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        HzApi.troutsService.getNaverMovies("토르")
            .enqueue(object: Callback<MoviesApi> {
                override fun onFailure(call: Call<MoviesApi>, t: Throwable) {

                }

                override fun onResponse(call: Call<MoviesApi>, response: Response<MoviesApi>?) {
                    response?.body()?.items?.let {

                    }
                }
            })
    }

}
