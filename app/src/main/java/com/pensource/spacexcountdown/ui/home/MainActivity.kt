package com.pensource.spacexcountdown.ui.home

import android.os.Bundle
import androidx.activity.compose.setContent
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pensource.spacexcountdown.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                TimeCard("Hello")
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