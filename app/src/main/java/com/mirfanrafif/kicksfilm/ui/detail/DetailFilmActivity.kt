package com.mirfanrafif.kicksfilm.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.mirfanrafif.kicksfilm.data.Movie
import com.mirfanrafif.kicksfilm.databinding.ActivityDetailFilmBinding

class DetailFilmActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var binding: ActivityDetailFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        val movie = extras?.getParcelable<Movie>(EXTRA_MOVIE)

        if (movie != null) {
            Glide.with(this@DetailFilmActivity).load(movie.photo).into(binding.imgDetail)
            setSupportActionBar(binding.toolbar)
            supportActionBar?.title = movie.title
            binding.contentDetail.textTahun.text = movie.year.toString()
            binding.contentDetail.textCategory.text = movie.category
            binding.contentDetail.textDescription.text = movie.overview
            binding.contentDetail.rating.max = 100
            binding.contentDetail.rating.progress = movie.rating
            binding.contentDetail.textRating.text = "${movie.rating}/100"
            binding.contentDetail.textDirector.text = movie.director
        }
    }
}