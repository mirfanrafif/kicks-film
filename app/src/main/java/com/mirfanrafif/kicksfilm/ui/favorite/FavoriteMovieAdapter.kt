package com.mirfanrafif.kicksfilm.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mirfanrafif.kicksfilm.R
import com.mirfanrafif.kicksfilm.databinding.FavoriteItemBinding
import com.mirfanrafif.kicksfilm.core.domain.model.Movie
import com.mirfanrafif.kicksfilm.ui.detail.DetailFilmActivity

class FavoriteMovieAdapter : RecyclerView.Adapter<FavoriteMovieAdapter.FavoriteMovieViewHolder>() {

    private val movieList = ArrayList<Movie>()

    fun setData(data: List<Movie>) {
        movieList.clear()
        movieList.addAll(data)
        notifyDataSetChanged()
    }

    inner class FavoriteMovieViewHolder(private val binding: FavoriteItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(entity: Movie) {
            with(binding) {
                Glide.with(binding.root.context).load(entity.photo)
                    .placeholder(R.drawable.ic_baseline_broken_image_24).into(imgFavorite)
                tvFavoriteTitle.text = entity.title
                tvFavoriteYear.text = entity.year.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_MOVIE, entity)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteMovieAdapter.FavoriteMovieViewHolder {
        val binding = FavoriteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteMovieAdapter.FavoriteMovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}