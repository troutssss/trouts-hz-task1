package com.example.hzz6.troutstask1

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel

/**
 * Created by janghj on 2019-09-26.
 */
class MovieItemViewModel(val context: Application): AndroidViewModel(context) {
    val title = ObservableField<String>()


    fun setData(movie: Movie) {
        title.set(movie.title)
    }
}