package com.example.newsapp.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://newsapi.org/v2/";


/**
 * We want retrofit to fetch for a JSON response from our web service and return it as a string.
 * Added the moshi converter factory to convert the JSON response to Kotlin objects.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

/**
 * Interface that defines how retrofit talks to our web server using HTTP requests.
 * Retrofit will create an object of our interface with all the methods that talk to the the server.
 */
interface NewsApiService {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("category") category: String,
        @Query("country") country: String,
        @Query("q") q: String,
        @Query("apiKey") apiKey: String
    ) : NewsAPIResponse

}

/**
 * Created the NewsApi object using Retrofit to implement the NewsApiService.
 * Calling the NewsApi.retrofitService object will return a retrofit object that implements NewsApiService.
 */
object NewsApi{
    val retrofitService : NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}


