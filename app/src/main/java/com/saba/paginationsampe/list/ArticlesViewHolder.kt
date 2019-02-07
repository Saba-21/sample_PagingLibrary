package com.saba.paginationsampe.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saba.domain.ArticleModel
import com.saba.paginationsampe.R
import kotlinx.android.synthetic.main.item.view.*

class ArticlesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(news: ArticleModel?) {
        if (news != null) {
            itemView.tvTitle.text = news.title
        }
    }

    companion object {
        fun create(parent: ViewGroup): ArticlesViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
            return ArticlesViewHolder(view)
        }
    }

}