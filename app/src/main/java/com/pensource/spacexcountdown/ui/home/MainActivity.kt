package com.pensource.spacexcountdown.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.pensource.spacexcountdown.R
import com.pensource.spacexcountdown.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            viewmodel = viewModel
            lifecycleOwner = this@MainActivity
        }
        setContentView(binding.root)

        Glide.with(this).load(R.drawable.falcon_nine_animation).into(binding.animation)

        viewModel.nextLaunch.observe(this, Observer {})

        viewModel.nextLaunchCountdown.observe(this, Observer {
            binding.countDownTimer.start(it)
        })
    }
}