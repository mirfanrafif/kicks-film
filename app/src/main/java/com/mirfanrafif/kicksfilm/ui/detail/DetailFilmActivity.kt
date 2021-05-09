package com.mirfanrafif.kicksfilm.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.mirfanrafif.kicksfilm.R
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity
import com.mirfanrafif.kicksfilm.databinding.ActivityDetailFilmBinding
import com.mirfanrafif.kicksfilm.viewmodel.ViewModelFactory

class DetailFilmActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var binding: ActivityDetailFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra(EXTRA_ID, 0)
        val type = intent.getStringExtra(EXTRA_TYPE)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        if (type != null) {
            viewModel.getDetailMovie(id, type).observe(this, { movie ->
                Glide.with(this@DetailFilmActivity).load(movie.photo).into(binding.imgDetail)
                setSupportActionBar(binding.toolbar)
                val rating = movie.rating.times(10).toInt()
                supportActionBar?.title = movie.title
                binding.contentDetail.textTahun.text = movie.year.toString()
                binding.contentDetail.textCategory.text = movie.category
                binding.contentDetail.textDescription.text = movie.overview
                binding.contentDetail.rating.max = 100
                binding.contentDetail.rating.progress = movie.rating.times(10).toInt()
                binding.contentDetail.textRating.text = getString(R.string.rating, rating)
            })
        }
    }
}