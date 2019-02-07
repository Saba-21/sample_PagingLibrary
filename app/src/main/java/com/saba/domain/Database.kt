package com.saba.domain

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(
    entities = [ArticleModel::class],
    version = 5,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

}