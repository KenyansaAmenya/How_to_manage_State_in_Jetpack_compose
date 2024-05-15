package com.example.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.state.ui.theme.StateTestViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[StateTestViewModel::class.java]
        setContent {
            StateTestScreen(viewModel)
        }
    }
}

