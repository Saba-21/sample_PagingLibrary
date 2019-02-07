package com.saba.domain

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface ArticleDao {

    @Query("Select * From article")
    fun select(): Flowable<List<ArticleModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(articles: List<ArticleModel>)

    @Delete
    fun drop(article: ArticleModel)

}