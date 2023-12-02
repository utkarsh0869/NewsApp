package com.example.newsapp.mainnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.network.models.Articles
import com.squareup.picasso.Picasso

class MainNewsAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<ArticleViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(article: Articles)
    }
    var data = listOf<Articles>()
        set(value)  {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutinflater = LayoutInflater.from(parent.context)
        val view = layoutinflater.inflate(
            R.layout.item_view, parent, false
        )
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = data[position]
        holder.bind(article, clickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val newsTitle: TextView = itemView.findViewById(R.id.newsTitle)
    private val newsDate : TextView = itemView.findViewById(R.id.newsDate)
    private val newsThumbnail : ImageView = itemView.findViewById(R.id.newsThumbnail)

    fun bind(article: Articles, clickListener: MainNewsAdapter.OnItemClickListener) {
        newsTitle.text = article.title
        newsDate.text = article.publishedAt
        Picasso.get().load(article.urlToImage).into(newsThumbnail)

        itemView.setOnClickListener {
            clickListener.onItemClick(article)
        }
    }

}
