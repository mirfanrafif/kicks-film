package com.mirfanrafif.kicksfilm.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.mirfanrafif.kicksfilm.R
import com.mirfanrafif.kicksfilm.ui.home.HomeActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch(Dispatchers.Default) {
            delay(1000)
            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
            finish()
        }
    }
}