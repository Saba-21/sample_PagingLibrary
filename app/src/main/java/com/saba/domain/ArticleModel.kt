package com.saba.domain

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "article")
data class ArticleModel(@PrimaryKey val title: String)