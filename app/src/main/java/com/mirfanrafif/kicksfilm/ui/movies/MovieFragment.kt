package com.mirfanrafif.kicksfilm.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.mirfanrafif.kicksfilm.data.Resource
import com.mirfanrafif.kicksfilm.databinding.FragmentMovieBinding
import com.mirfanrafif.kicksfilm.ui.viewmodel.ViewModelFactory

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
            val layoutManager = GridLayoutManager(context, 3)
            val adapter = MoviesAdapter()
            binding.rvMovies.adapter = adapter
            binding.rvMovies.layoutManager = layoutManager

            val factory = ViewModelFactory.getInstance(requireContext())
            val viewModel = ViewModelProvider(requireActivity(), factory)[MoviesViewModel::class.java]
            viewModel.getAllMovies().observe(this, {
                if (it != null) {
                    when(it) {
                        is Resource.Loading -> binding.movieLoading.visibility = View.VISIBLE
                        is Resource.Success -> {
                            adapter.setData(it.data)
                            binding.movieLoading.visibility = View.GONE
                        }
                        is Resource.Error -> {
                            binding.movieLoading.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
    }
}