package com.example.newsapp.network.models

import com.squareup.moshi.Json
import java.io.Serializable

data class Articles(@Json(name = "source")val source: Source,
                    @Json(name = "author")val author: String,
                    @Json(name = "title")val title: String,
                    @Json(name = "description")val description: String,
                    @Json(name = "url")val url: String,
                    @Json(name = "urlToImage")val urlToImage: String,
                    @Json(name = "publishedAt")val publishedAt: String,
                    @Json(name = "content")val content: String) : Serializable {}