package com.example.testcompose.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.testcompose.DAO.ProductDao
import com.example.testcompose.model.Product
import com.example.testcompose.ui.components.sampleCandies
import com.example.testcompose.ui.components.sampleDrinks
import com.example.testcompose.ui.components.sampleProducts
import com.example.testcompose.ui.states.HomeViewUiState


class HomeViewViewmodel : ViewModel() {

  private val dao = ProductDao()

  var uiState: HomeViewUiState by mutableStateOf(HomeViewUiState(
    sections = mapOf(
      "Novos produtos" to dao.products(),
      "Promos" to sampleCandies + sampleDrinks,
    ),
    onSearchChange = {
      uiState = uiState.copy(searchText = it, searchedProducts = searchedProducts(it))
    }
  ))
    private set

  private fun filterByNameAndDescription(text:String) = { product: Product ->
    product.name.contains(text, ignoreCase = true) ||
        product.description?.contains(text, ignoreCase = true) ?: false
  }

  private fun searchedProducts( text:String): List<Product> {
    return sampleProducts
      .filter(filterByNameAndDescription(text)) + dao.products().filter(filterByNameAndDescription(text))
  }
}