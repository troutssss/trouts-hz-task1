package com.example.hzz6.troutstask1

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        HzApi.troutsService.getNaverMovies("토르")
            .enqueue(object: Callback<MoviesApi> {
                override fun onFailure(call: Call<MoviesApi>, t: Throwable) {

                }

                override fun onResponse(call: Call<MoviesApi>, response: Response<MoviesApi>) {
                    Log.i(TAG, "${response.body()}")
                }
            })
    }

}
