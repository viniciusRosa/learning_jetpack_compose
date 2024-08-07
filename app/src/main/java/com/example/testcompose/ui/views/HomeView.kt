package com.example.testcompose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcompose.model.Product
import com.example.testcompose.ui.components.ProductSection
import com.example.testcompose.ui.components.sampleSections
import com.example.testcompose.ui.theme.TestComposeTheme

@Composable
fun HomeView(sections: Map<String, List<Product>>) {
  LazyColumn(
    Modifier
      .fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    contentPadding = PaddingValues(vertical = 16.dp)
  ) {
    for (section in sections) {
      val title = section.key
      val products = section.value
      item {
        ProductSection(sectionName = title, products = products)
      }
    }
  }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeViewPreview() {
  TestComposeTheme {
    Surface {
      HomeView(sampleSections)
    }
  }
}