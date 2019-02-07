package com.saba.paginationsampe

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.saba.domain.ArticleModel
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    private val data: LiveData<PagedList<ArticleModel>>,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {

    fun getArticles(): LiveData<PagedList<ArticleModel>> = data

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}