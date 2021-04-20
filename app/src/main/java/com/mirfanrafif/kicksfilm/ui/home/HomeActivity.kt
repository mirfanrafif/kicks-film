package com.mirfanrafif.kicksfilm.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.mirfanrafif.kicksfilm.R
import com.mirfanrafif.kicksfilm.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val tabName = resources.getStringArray(R.array.tab_name)

        val sectionPagesAdapter = SectionPagesAdapter(this)
        binding.viewpager.adapter = sectionPagesAdapter
        TabLayoutMediator(binding.tabs, binding.viewpager) {tabs, position ->
            tabs.text = tabName[position]
        }.attach()

//        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[HomeViewModel::class.java]
    }
}