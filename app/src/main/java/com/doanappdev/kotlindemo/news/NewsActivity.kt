package com.doanappdev.kotlindemo.news

import android.os.Bundle
import android.util.Log
import com.doanappdev.kotlindemo.DemoApplication
import com.doanappdev.kotlindemo.R
import com.doanappdev.kotlindemo.base.BaseActivity

import kotlinx.android.synthetic.main.activity_news.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class NewsActivity : BaseActivity() {

    val TAG : String = NewsActivity::class.java.name


    @Inject lateinit var newsManager: NewsManager

    private var redditNews: RedditNews? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        DemoApplication.appComponent.inject(this)

        //setSupportActionBar(toolbar)

        requestNews()

    }

    private fun requestNews() {
        val subscription = newsManager.getNews(redditNews?.after ?: "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { retrievedNews -> Log.d(TAG, "retrievedNews $retrievedNews")},
                        { e -> Log.e(TAG, "error retrievingNews $e")}
                )

        subscriptions.add(subscription)
    }
}
