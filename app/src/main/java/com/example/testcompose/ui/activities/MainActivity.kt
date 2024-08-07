package com.example.testcompose.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.testcompose.ui.components.sampleSections
import com.example.testcompose.ui.theme.TestComposeTheme
import com.example.testcompose.ui.views.HomeView

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      App()
    }
  }
}

@Composable
fun App() {
  TestComposeTheme {
    Scaffold(
      topBar = { ScaffoldTopBar() },
    ) {
      Box (
        modifier = Modifier.padding(it)
      ) {
        HomeView(sampleSections)
//        ScaffoldImage()
      }
    }
//    Surface {
//      HomeView(sampleSections)
//    }
  }
}

@Composable
fun ScaffoldTopBar(modifier: Modifier = Modifier) {
  Row(modifier = Modifier
    .background(Color.Red)
    .padding(12.dp)
    .fillMaxWidth()
  ) {

  }
}




