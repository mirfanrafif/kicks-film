package com.mirfanrafif.kicksfilm.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.mirfanrafif.kicksfilm.databinding.FragmentMovieBinding
import com.mirfanrafif.kicksfilm.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val layoutManager = GridLayoutManager(context, 2)
            val adapter = MoviesAdapter()
            binding.rvMovies.adapter = adapter
            binding.rvMovies.layoutManager = layoutManager

            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(requireActivity(), factory)[MoviesViewModel::class.java]
            viewModel.getAllMovies().observe(this, {
                adapter.setData(it)
            })
        }
    }
}