package com.mirfanrafif.kicksfilm.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.mirfanrafif.kicksfilm.R
import com.mirfanrafif.kicksfilm.databinding.ActivityDetailFilmBinding
import com.mirfanrafif.kicksfilm.domain.model.Movie
import com.mirfanrafif.kicksfilm.ui.viewmodel.ViewModelFactory

class DetailFilmActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var binding: ActivityDetailFilmBinding
    private lateinit var viewModel: DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)


        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        if (movie != null) {
            viewModel.setMovie(movie)
            bindDataToView()
        }
    }

    private fun bindDataToView() {
        viewModel.getMovie().observe(this, { data ->
            Glide.with(this@DetailFilmActivity).load(data.photo).into(binding.imgDetail)
            val rating = data.rating.times(10).toInt()
            supportActionBar?.title = data.title
            binding.contentDetail.textTahun.text = data.year.toString()
            binding.contentDetail.textCategory.text = data.category
            binding.contentDetail.textDescription.text = data.overview
            binding.contentDetail.ratingBar.max = 100
            binding.contentDetail.ratingBar.progress = data.rating.times(10).toInt()
            binding.contentDetail.textRating.text = getString(R.string.rating, rating)
            setFabImage(data.isFavorite)
            binding.favoriteFab.setOnClickListener {
                data.isFavorite = !data.isFavorite
                viewModel.updateMovie(data)
                setFabImage(data.isFavorite)
            }
        })
    }

    private fun setFabImage(isFavorite: Boolean) {
        binding.favoriteFab.setImageResource(
            if(isFavorite) R.drawable.ic_baseline_favorite_24
            else R.drawable.ic_baseline_favorite_border_24
        )
    }
}