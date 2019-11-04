package com.recyclerviewmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {


    private val list = mutableListOf<Movie>()
    private val _items = MutableLiveData<List<Movie>>().apply { value = list }

    private val repository = MovieRepository(MovieApi())

    val items: LiveData<List<Movie>>
        get() = _items

    init {
        fetchData()
    }

    private fun fetchData() {

        GlobalScope.launch(Dispatchers.Main) {
            val movies = repository.getData()
            _items.value = movies

     }

    }

}