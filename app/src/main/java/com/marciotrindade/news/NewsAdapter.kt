package com.marciotrindade.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marciotrindade.news.api.model.Article
import com.marciotrindade.news.api.model.Response
import com.marciotrindade.news.databinding.ItemNewsBinding

class NewsAdapter(val newsList:Response):RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
       val view = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(view,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.bind(newsList.articles[position])
    }

    override fun getItemCount(): Int {
      return newsList.articles.size
    }

    class ViewHolder(private val binding:ItemNewsBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(news: Article) = with(binding){
            val img = news.urlToImage
            Glide.with(itemView.context).load(img).into(imgNews)
            titleNews.text=news.title
            contentNews.text = news.description

        }
    }
}