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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcompose.ui.components.CardProductItem
import com.example.testcompose.ui.components.PartnersSection
import com.example.testcompose.ui.components.ProductSection
import com.example.testcompose.ui.components.SearchTextField
import com.example.testcompose.ui.components.sampleSections
import com.example.testcompose.ui.components.sampleShopSections
import com.example.testcompose.ui.states.HomeViewUiState
import com.example.testcompose.ui.theme.TestComposeTheme
import com.example.testcompose.ui.viewmodels.HomeViewViewmodel

@Composable
fun HomeView(
  viewModel: HomeViewViewmodel
) {

  val state by viewModel.uiState.collectAsState()
  HomeView(state)
}

@Composable
fun HomeView(
  state: HomeViewUiState = HomeViewUiState()
) {
  Column {
    val sections = state.sections
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