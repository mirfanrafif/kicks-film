package com.mirfanrafif.kicksfilm.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.mirfanrafif.kicksfilm.core.utils.EspressoIdlingResource
import com.mirfanrafif.kicksfilm.databinding.ActivityMainBinding
import com.mirfanrafif.kicksfilm.home.HomeActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        EspressoIdlingResource.increment()
        lifecycleScope.launch(Dispatchers.Default) {
            delay(1000)
            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
            EspressoIdlingResource.decrement()
            finish()
        }
    }
}