package com.mirfanrafif.kicksfilm.ui.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirfanrafif.kicksfilm.databinding.ActivityFavoriteBinding
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteActivity : AppCompatActivity() {
    private val viewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieAdapter = FavoriteMovieAdapter()
        val layoutManager = LinearLayoutManager(this)

        binding.rvFavoriteMovies.adapter = movieAdapter
        binding.rvFavoriteMovies.layoutManager = layoutManager

        viewModel.getFavoriteMovies().observe(this, {
            movieAdapter.setData(it)
        })
    }
}