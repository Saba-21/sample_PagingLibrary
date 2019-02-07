package com.saba.paginationsampe

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.saba.paginationsampe.list.ArticlesListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var articlesListAdapter: ArticlesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        articlesListAdapter = ArticlesListAdapter()
        rvList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, true)
        rvList.adapter = articlesListAdapter

        mainViewModel.getArticles().observe(this, Observer {

            articlesListAdapter.submitList(it)

        })
    }

}