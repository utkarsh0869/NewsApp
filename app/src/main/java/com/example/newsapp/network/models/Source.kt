package com.example.newsapp.network.models

import com.squareup.moshi.Json
import java.io.Serializable

data class Source (
    @Json(name = "id")val id: String,
    @Json(name = "name")val name: String
) : Serializable {}