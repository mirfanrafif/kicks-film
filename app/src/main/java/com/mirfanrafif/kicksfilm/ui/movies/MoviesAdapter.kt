package com.mirfanrafif.kicksfilm.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mirfanrafif.kicksfilm.R
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity
import com.mirfanrafif.kicksfilm.databinding.ItemMoviesBinding
import com.mirfanrafif.kicksfilm.ui.detail.DetailFilmActivity

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private val movies = ArrayList<MovieEntity>()

    fun setData(data: List<MovieEntity>) {
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

    class MoviesViewHolder(private val binding: ItemMoviesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movieEntity: MovieEntity) {
            with(binding) {
                namaFilm.text = movieEntity.title
                tahunFilm.text = movieEntity.year.toString()
                Glide.with(itemView).load(movieEntity.photo).placeholder(R.drawable.ic_baseline_broken_image_24).into(imgThumbnail)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_ID, movieEntity.id)
                    intent.putExtra(DetailFilmActivity.EXTRA_TYPE, "movie")
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

}