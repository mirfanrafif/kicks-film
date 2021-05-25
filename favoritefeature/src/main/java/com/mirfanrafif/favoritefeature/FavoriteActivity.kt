package com.mirfanrafif.favoritefeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mirfanrafif.favoritefeature.databinding.ActivityFavoriteBinding
import com.mirfanrafif.kicksfilm.di.favoriteModule
import com.mirfanrafif.kicksfilm.favorite.FavoriteViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val viewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        val movieAdapter = FavoriteMovieAdapter()
        val layoutManager = LinearLayoutManager(this)

        binding.rvFavoriteMovies.adapter = movieAdapter
        binding.rvFavoriteMovies.layoutManager = layoutManager

        viewModel.getFavoriteMovies().observe(this, {
            movieAdapter.setData(it)
        })
    }
}