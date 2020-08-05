package com.pensource.spacexcountdown.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.pensource.spacexcountdown.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: HomeViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            viewmodel = viewModel
            lifecycleOwner = this@MainActivity
        }
        setContentView(binding.root)

        viewModel.nextLaunch.observe(this, Observer {})

        viewModel.nextLaunchCountdown.observe(this, Observer {
            binding.countDownTimer.start(it)
        })
    }
}