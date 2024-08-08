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
import com.example.testcompose.ui.components.sampleCandies
import com.example.testcompose.ui.components.sampleDrinks
import com.example.testcompose.ui.components.sampleProducts
import com.example.testcompose.ui.components.sampleSections
import com.example.testcompose.ui.components.sampleShopSections
import com.example.testcompose.ui.theme.TestComposeTheme

class HomeViewUiState(
  val sections: Map<String, List<Product>> = emptyMap(),
  val searchedProducts: List<Product> = emptyList(),
  val searchText: String = "",
  val onSearchChange: (String) -> Unit = {}
) {

  fun isShowSections(): Boolean {
    return searchText.isBlank()
  }
}

@Composable
fun HomeView(products: List<Product>) {

  val sections = mapOf(
    "Novos produtos" to products,
    "Promos" to sampleCandies + sampleDrinks,
  )

  var text by remember {
    mutableStateOf("")
  }

  fun filterByNameAndDescription() = { product: Product ->
    product.name.contains(text, ignoreCase = true) ||
        product.description?.contains(text, ignoreCase = true) ?: false
  }

  val searchedProducts = remember(products, text) {
    sampleProducts
      .filter(filterByNameAndDescription()) + products.filter(filterByNameAndDescription())
  }


  val state = remember(products, text) {
    HomeViewUiState(
      sections = sections,
      searchedProducts = searchedProducts,
      searchText = text,
      onSearchChange = { text = it }
    )
  }

  HomeView(state)
}

@Composable
fun HomeView(
  state: HomeViewUiState = HomeViewUiState()
) {
  Column {
    val sections = remember(state.sections) {
      state.sections
    }
    val searchedProducts = state.searchedProducts
    SearchTextField(
      searchText = state.searchText,
      onSearchChange = state.onSearchChange,
    )
    LazyColumn(
      Modifier
        .fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      contentPadding = PaddingValues(bottom = 16.dp)
    ) {
      if (state.isShowSections()) {
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
      HomeView(HomeViewUiState(sections = sampleSections))
    }
  }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeViewSearchPreview() {
  TestComposeTheme {
    Surface {
      HomeView(
        state = HomeViewUiState(sections = sampleSections, searchText = "a")
      )
    }
  }
}