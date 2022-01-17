package com.pensource.spacexcountdown.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.pensource.spacexcountdown.R
import com.pensource.spacexcountdown.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

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

        findViewById<ComposeView>(R.id.compose_view).setContent {
            MaterialTheme {
                TimeCard("SPACEX COUNTDOWN")
            }
        }
    }
}

@Composable
fun TimeCard(time: String) {
    Card(backgroundColor = Color.Black) {
        Column {
            Image(painterResource(R.drawable.ic_logo_only_x), "Falcon")
            Text(
                time,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center,
                color = Color.Red
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        TimeCard("SPACEX COUNTDOWN")
    }
}