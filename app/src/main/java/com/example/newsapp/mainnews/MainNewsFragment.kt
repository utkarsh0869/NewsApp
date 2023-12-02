package com.example.newsapp.mainnews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.detailnews.DetailNewsFragment
import com.example.newsapp.mainnews.adapter.MainNewsAdapter
import com.example.newsapp.network.models.Articles

class MainNewsFragment : Fragment(), MainNewsAdapter.OnItemClickListener {

    private lateinit var viewModel: MainNewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_news, container, false)

        viewModel = ViewModelProvider(this)[MainNewsViewModel::class.java]

        // Access RecyclerView from the inflated view
        val rv: RecyclerView = view.findViewById(R.id.mainNewsRV)

        val adapter = MainNewsAdapter(this)
        rv.adapter = adapter

        // Observe changes in articlesList LiveData and update the adapter's data
        viewModel.articlesList.observe(viewLifecycleOwner) { articles ->
            adapter.data = articles
        }

        return view
    }


    override fun onItemClick(article: Articles) {
        val bundle = Bundle()
        bundle.putSerializable("article", article)

//        // Get the NavController from the NavigationHostFragment or NavHostFragment
//        val navController = findNavController()
//        navController.navigate(R.id.action_mainNewsFragment_to_detailNewsFragment, bundle)

        val destinationFragment = DetailNewsFragment() // Replace 'DetailsFragment' with your destination fragment
        destinationFragment.arguments = bundle

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, destinationFragment)
        fragmentTransaction.addToBackStack(null) // Optional: Add transaction to the back stack
        fragmentTransaction.commit()
    }


}