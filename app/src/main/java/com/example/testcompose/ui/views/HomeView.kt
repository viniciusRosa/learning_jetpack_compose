package com.example.testcompose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcompose.model.Product
import com.example.testcompose.ui.components.CardProductItem
import com.example.testcompose.ui.components.PartnersSection
import com.example.testcompose.ui.components.ProductSection
import com.example.testcompose.ui.components.SearchTextField
import com.example.testcompose.ui.components.sampleProducts
import com.example.testcompose.ui.components.sampleSections
import com.example.testcompose.ui.components.sampleShopSections
import com.example.testcompose.ui.theme.TestComposeTheme

@Composable
fun HomeView(sections: Map<String, List<Product>>, searchText: String = "") {
  Column {
    var text by remember { mutableStateOf(searchText) }
    val searchedProducts = remember(text) {
      sampleProducts.filter { product: Product ->
        product.name.contains(text, ignoreCase = true) ||
            product.description?.contains(text, ignoreCase = true) ?: false
      }
    }
    SearchTextField(searchText = text, onSearchChange = { text = it })
    LazyColumn(
      Modifier
        .fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      contentPadding = PaddingValues(bottom = 16.dp)
    ) {
      if (text.isBlank()) {
        for (section in sections) {
          val title = section.key
          val products = section.value
          item {
            ProductSection(sectionName = title, products = products)
          }
        }

        for (shop in sampleShopSections) {
          val title = shop.key
          val partner = shop.value
          item {
            PartnersSection(title = title, shop = partner)
          }
        }
      } else {
        items(searchedProducts) { p ->
          CardProductItem(
            product = p,
            Modifier.padding(horizontal = 16.dp)
          )
        }
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

@Preview(showSystemUi = true)
@Composable
private fun HomeViewSearchPreview() {
  TestComposeTheme {
    Surface {
      HomeView(sampleSections, "c")
    }
  }
}