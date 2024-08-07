package com.example.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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
//        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//          Greeting(
//            name = "Android",
//            modifier = Modifier.padding(innerPadding)
//          )
//        }
    Surface {
      HomeView(sampleSections)
    }
  }
}




