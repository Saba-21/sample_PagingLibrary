package com.saba.paginationsampe.list

import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.saba.domain.ArticleApi
import com.saba.domain.ArticleModel
import io.reactivex.disposables.CompositeDisposable

class ArticlesDataSource(
    private val networkService: ArticleApi,
    private val compositeDisposable: CompositeDisposable
) : PageKeyedDataSource<Int, ArticleModel>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, ArticleModel>) {
        compositeDisposable.add(
            networkService.getArticles(1, params.requestedLoadSize)
                .subscribe(
                    {
                        callback.onResult(it.articles, null, 2)
                    }, {

                    }
                )
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleModel>) {
        compositeDisposable.add(
            networkService.getArticles(params.key, params.requestedLoadSize)
                .subscribe(
                    {
                        callback.onResult(it.articles, params.key + 1)
                    }, {

                    }
                )
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleModel>) {
        Log.e("","")
    }

}