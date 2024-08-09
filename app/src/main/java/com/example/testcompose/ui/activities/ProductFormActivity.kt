package com.example.testcompose.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import com.example.testcompose.ui.theme.TestComposeTheme
import com.example.testcompose.ui.viewmodels.ProductFormViewModel
import com.example.testcompose.ui.views.ProductFormScreen

class ProductFormActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TestComposeTheme {
        Surface {
          val viewModel: ProductFormViewModel by viewModels()
          ProductFormScreen(
            viewModel = viewModel,
            onSaveClick = {
              finish()
            }
          )
        }
      }
    }
  }
}

