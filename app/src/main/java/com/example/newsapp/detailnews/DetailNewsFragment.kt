package com.example.newsapp.detailnews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.newsapp.R
import com.example.newsapp.network.models.Articles

class DetailNewsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_news, container, false)

        val args = arguments?.getSerializable("article") as? Articles

        val newsDetailTitle : TextView = view.findViewById(R.id.newsDetailTitle)
        val newsDetailDate : TextView = view.findViewById(R.id.newsDetailDate)
        val newsDetailAuthor : TextView = view.findViewById(R.id.newsDetailAuthor)
        val newsDetailSource : TextView = view.findViewById(R.id.newsDetailSource)
        val newsDetailDescription : TextView = view.findViewById(R.id.newsDetailDescription)
        val newsDetailLink : TextView = view.findViewById(R.id.newsDetailLink)

        if (args != null) {
            newsDetailTitle.text = args.title
            newsDetailDate.text = args.publishedAt
            newsDetailAuthor.text = args.author
            newsDetailSource.text = args.source.name
            newsDetailDescription.text = args.description
            newsDetailLink.text = args.url
        }


        return view
    }

}