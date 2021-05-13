package com.mirfanrafif.kicksfilm.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mirfanrafif.kicksfilm.R
import com.mirfanrafif.kicksfilm.data.entities.MovieEntity
import com.mirfanrafif.kicksfilm.databinding.FavoriteItemBinding
import com.mirfanrafif.kicksfilm.ui.detail.DetailFilmActivity

class FavoriteMovieAdapter : RecyclerView.Adapter<FavoriteMovieAdapter.FavoriteMovieViewHolder>() {

    private val favoriteMoviesList = ArrayList<MovieEntity>()

    fun setData(data: List<MovieEntity>) {
        favoriteMoviesList.clear()
        favoriteMoviesList.addAll(data)
        notifyDataSetChanged()
    }

    inner class FavoriteMovieViewHolder(private val binding: FavoriteItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(entity: MovieEntity) {
            with(binding) {
                Glide.with(binding.root.context).load(entity.photo)
                    .placeholder(R.drawable.ic_baseline_broken_image_24).into(imgFavorite)
                tvFavoriteTitle.text = entity.title
                tvFavoriteYear.text = entity.year.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_ID, entity.id)
                    intent.putExtra(DetailFilmActivity.EXTRA_TYPE, "movie")
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
        holder.bind(favoriteMoviesList[position])
    }

    override fun getItemCount(): Int = favoriteMoviesList.size
}