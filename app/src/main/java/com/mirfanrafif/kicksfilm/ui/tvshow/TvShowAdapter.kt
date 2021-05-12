package com.mirfanrafif.kicksfilm.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mirfanrafif.kicksfilm.R
import com.mirfanrafif.kicksfilm.data.entities.TvShowEntity
import com.mirfanrafif.kicksfilm.databinding.ItemMoviesBinding
import com.mirfanrafif.kicksfilm.ui.detail.DetailFilmActivity

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>()  {
    private val movies = ArrayList<TvShowEntity>()

    fun setData(data: List<TvShowEntity>) {
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

    class TvShowViewHolder(private val binding: ItemMoviesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(entity: TvShowEntity) {
            with(binding) {
                namaFilm.text = entity.title
                tahunFilm.text = entity.year.toString()
                Glide.with(itemView).load(entity.photo).placeholder(R.drawable.ic_baseline_broken_image_24).into(imgThumbnail)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
                    intent.putExtra(DetailFilmActivity.EXTRA_ID, entity.id)
                    intent.putExtra(DetailFilmActivity.EXTRA_TYPE, "tvshow")
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}