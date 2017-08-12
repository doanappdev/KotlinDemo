package com.doanappdev.kotlindemo.di

import com.doanappdev.kotlindemo.DemoApplication
import com.doanappdev.kotlindemo.MainActivity
import com.doanappdev.kotlindemo.di.news.NewsModule
import com.doanappdev.kotlindemo.news.NewsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, NewsModule::class))
interface ApplicationComponent {
    fun inject(application: DemoApplication)
    fun inject(mainActivity: MainActivity)
    fun inject(newsActivity: NewsActivity)
}
