package com.example.testcompose.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testcompose.ui.theme.TestComposeTheme
import com.example.testcompose.ui.viewmodels.HomeViewViewmodel
import com.example.testcompose.ui.views.HomeView

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      App(onFABClick = {
        startActivity(Intent(this, ProductFormActivity::class.java))
      }) {
        val viewModel by viewModels<HomeViewViewmodel>()
        HomeView(viewModel)
      }
    }
  }
}

@Composable
fun App(onFABClick: () -> Unit = {}, content: @Composable () -> Unit = {}) {
  TestComposeTheme {
    Scaffold(
      floatingActionButton = {
        FloatingActionButton(onClick = onFABClick) {
          Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
      }
    ) { paddingValues ->
      Box(modifier = Modifier.padding(paddingValues)) {
        content()
      }

    }
  }
}



