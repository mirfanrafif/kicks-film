package com.mirfanrafif.kicksfilm.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.mirfanrafif.kicksfilm.R
import com.mirfanrafif.kicksfilm.databinding.ActivityHomeBinding
import com.mirfanrafif.kicksfilm.movies.MovieFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportFragmentManager.beginTransaction()
            .add(R.id.wrapper, MovieFragment())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.favoriteMenu -> {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("kicksfilm://favorite")))
            }
        }
        return true
    }
}