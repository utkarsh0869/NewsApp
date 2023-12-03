package com.example.newsapp.mainnews

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsapp.network.NewsApi
import com.example.newsapp.network.models.Articles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainNewsViewModel(application: Application) : AndroidViewModel(application){

    private val _articlesList = MutableLiveData<List<Articles>>()
    val articlesList: LiveData<List<Articles>> get() = _articlesList

    init {
        viewModelScope.launch {
            fetchNewsAndDisplay()
        }
    }

    private suspend fun fetchNewsAndDisplay() {
        withContext(Dispatchers.IO) {
            try {
                val category = "business"
                val country = "us"
                val query = ""
                val apiKey = "dfcf1a29e0ee4a79a8f9cd2b93afe259"

                val response = NewsApi.retrofitService.getNews(category, country, query, apiKey)

                if (response.status == "ok") {
                    _articlesList.postValue(response.articles)
                } else {
                    null
                }

            } catch (err: Exception) {
                Log.e("fetchNewsAndDisplay", err.printStackTrace().toString())
            }
        }
    }
}
