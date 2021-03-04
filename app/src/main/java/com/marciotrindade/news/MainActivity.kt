package com.marciotrindade.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.marciotrindade.news.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        viewModel.getNews()


        viewModel.articlesMutableLive.observe(this, { list ->
            binding.rvNews.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = NewsAdapter(list)
            }
        })


    }
}