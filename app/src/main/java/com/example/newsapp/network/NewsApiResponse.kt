package com.example.newsapp.network

import com.example.newsapp.network.models.Articles
import java.io.Serializable

data class NewsAPIResponse(val status: String, val totalResults: Int, val articles: List<Articles>) :
    Serializable {}