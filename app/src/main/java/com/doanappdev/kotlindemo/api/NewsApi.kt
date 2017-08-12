package com.doanappdev.kotlindemo.api

import retrofit2.Call

interface NewsApi {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}