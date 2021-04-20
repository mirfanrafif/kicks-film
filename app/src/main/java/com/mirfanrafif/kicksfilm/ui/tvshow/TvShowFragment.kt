package com.mirfanrafif.kicksfilm.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.mirfanrafif.kicksfilm.databinding.FragmentTvShowBinding
import com.mirfanrafif.kicksfilm.ui.home.HomeViewModel
import com.mirfanrafif.kicksfilm.ui.movies.MoviesAdapter

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
            val viewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[HomeViewModel::class.java]
            val adapter = MoviesAdapter()
            val layoutManager = GridLayoutManager(context, 2)

            binding.rvTvShows.adapter = adapter
            binding.rvTvShows.layoutManager = layoutManager
            adapter.setData(viewModel.getTvShows())
        }
    }
}