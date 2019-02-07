package com.saba.domain

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApi {

    @GET("everything?q=sports&apiKey=afecda1c50dc48eba42d5c7097b6b40a")
    fun getArticles(@Query("page") page: Int, @Query("pageSize") pageSize: Int): Single<ResponseModel>

}