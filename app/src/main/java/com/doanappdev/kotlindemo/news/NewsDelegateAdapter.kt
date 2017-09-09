package com.doanappdev.kotlindemo.news

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.doanappdev.kotlindemo.R
import com.doanappdev.kotlindemo.adapter.ViewType
import com.doanappdev.kotlindemo.adapter.ViewTypeDelegateAdapter
import com.doanappdev.kotlindemo.extensions.inflate

import kotlinx.android.synthetic.main.news_item.view.*

class NewsDelegateAdapter : ViewTypeDelegateAdapter {

    interface onViewSelectedListener {
        fun onItemSelected(url: String?)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    inner class NewsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item)) {
        fun bind(item: RedditNewsItem) = with(itemView) {
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            //time.text = //item.created.getFr

            //super.itemView.setOnClickListener { viewAc }
        }
    }
}