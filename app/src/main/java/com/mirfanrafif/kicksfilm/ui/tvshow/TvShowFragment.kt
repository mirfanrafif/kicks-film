package com.mirfanrafif.kicksfilm.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.mirfanrafif.kicksfilm.databinding.FragmentTvShowBinding
import com.mirfanrafif.kicksfilm.ui.movies.MoviesAdapter
import com.mirfanrafif.kicksfilm.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {

    private lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTvShowBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(requireActivity(), factory)[TvShowViewModel::class.java]
            val adapter = TvShowAdapter()
            val layoutManager = GridLayoutManager(context, 2)

            binding.rvTvShows.adapter = adapter
            binding.rvTvShows.layoutManager = layoutManager
            viewModel.getAllTvShow().observe(this, {
                adapter.setData(it)
            })

        }
    }
}