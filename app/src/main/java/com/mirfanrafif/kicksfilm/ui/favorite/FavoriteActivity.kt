package com.mirfanrafif.kicksfilm.ui.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirfanrafif.kicksfilm.databinding.ActivityFavoriteBinding
import com.mirfanrafif.kicksfilm.ui.viewmodel.ViewModelFactory

class FavoriteActivity : AppCompatActivity() {
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

        val movieAdapter = FavoriteMovieAdapter()
        val layoutManager = LinearLayoutManager(this)

        binding.rvFavoriteMovies.adapter = movieAdapter
        binding.rvFavoriteMovies.layoutManager = layoutManager

        viewModel.getFavoriteMovies().observe(this, {
            movieAdapter.setData(it)
        })
    }
}