package com.doanappdev.kotlindemo.api

import retrofit2.Call
import javax.inject.Inject

class NewsRestApi @Inject constructor(private val redditApi: RedditApi) : NewsApi {

    override fun getNews(after: String, limit: String): Call<RedditNewsResponse> {
        return redditApi.getTop(after, limit)
    }
}