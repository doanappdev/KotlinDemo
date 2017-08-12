package com.doanappdev.kotlindemo.di.news

import com.doanappdev.kotlindemo.api.NewsApi
import com.doanappdev.kotlindemo.api.NewsRestApi
import com.doanappdev.kotlindemo.api.RedditApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NewsModule {
    @Provides
    @Singleton
    fun providesNewsApi(redditApi: RedditApi): NewsApi = NewsRestApi(redditApi)

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): RedditApi = retrofit.create(RedditApi::class.java)

    /**
     * NewsManager is automatically provided by Dagger as we set the @Inject annotation in the
     * constructor, so we can avoid adding a 'provider method' here.
     */
}