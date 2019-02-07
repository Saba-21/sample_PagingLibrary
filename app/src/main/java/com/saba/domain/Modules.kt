package com.saba.domain

import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import retrofit2.Retrofit
import android.arch.persistence.room.Room
import com.saba.paginationsampe.MainViewModel
import com.saba.paginationsampe.list.ArticlesDataSource
import com.saba.paginationsampe.list.ArticlesDataSourceFactory
import io.reactivex.disposables.CompositeDisposable
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Modules {

    val articleModule = module {

        single {
            Retrofit
                .Builder()
                .baseUrl("https://newsapi.org/v2/")
                .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ArticleApi::class.java)
        }

        single {
            PagedList
                .Config
                .Builder()
                .setPageSize(2)
                .setInitialLoadSizeHint(2)
                .setEnablePlaceholders(false)
                .build()
        }

        single {
            Room
                .databaseBuilder(androidApplication(), Database::class.java, "repo_db")
                .fallbackToDestructiveMigration()
                .build()
                .articleDao()
        }

        viewModel {
            val disposable = CompositeDisposable()
            val dataSource = ArticlesDataSource(get(), disposable)
            val dataSourceFactory = ArticlesDataSourceFactory(dataSource)
            val articlesLiveData = LivePagedListBuilder<Int, ArticleModel>(dataSourceFactory, get<PagedList.Config>()).build()
            MainViewModel(articlesLiveData, disposable)
        }

    }

}