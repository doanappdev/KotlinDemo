package com.doanappdev.kotlindemo.di.news

import com.doanappdev.kotlindemo.di.AppModule
import com.doanappdev.kotlindemo.di.NetworkModule
import com.doanappdev.kotlindemo.news.NewsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NetworkModule::class,
        NewsModule::class)
)
interface NewsComponent {
    //fun inject(newsFragment)
    fun inject(newsActivity: NewsActivity)
}
