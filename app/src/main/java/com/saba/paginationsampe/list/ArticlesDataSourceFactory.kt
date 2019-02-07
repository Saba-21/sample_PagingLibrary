package com.saba.paginationsampe.list

import android.arch.paging.DataSource
import com.saba.domain.ArticleModel

class ArticlesDataSourceFactory(
    private val articlesDataSource: ArticlesDataSource
) : DataSource.Factory<Int, ArticleModel>() {

    override fun create(): DataSource<Int, ArticleModel> = articlesDataSource

}