package com.example.testcompose.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testcompose.DAO.ProductDao
import com.example.testcompose.model.Product
import com.example.testcompose.ui.components.sampleCandies
import com.example.testcompose.ui.components.sampleDrinks
import com.example.testcompose.ui.components.sampleProducts
import com.example.testcompose.ui.states.HomeViewUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeViewViewmodel : ViewModel() {

  private val dao = ProductDao()

  private val _uiState: MutableStateFlow<HomeViewUiState> = MutableStateFlow(
    HomeViewUiState())

  val uiState get() = _uiState.asStateFlow()

  init {
    _uiState.update { currentState ->
      currentState.copy(
        onSearchChange = {
          _uiState.value = _uiState.value.copy(
            searchText = it,
            searchedProducts = searchedProducts(it)
          )
        }
      )
    }

    viewModelScope.launch {
      dao.products().collect{ products ->
        _uiState.value = _uiState.value.copy(
          sections = mapOf(
          "Novos produtos" to products,
          "Promos" to sampleCandies + sampleDrinks,
        ),
          searchedProducts = searchedProducts(_uiState.value.searchText)

        )
      }
    }

  }

  private fun filterByNameAndDescription(text:String) = { product: Product ->
    product.name.contains(text, ignoreCase = true) ||
        product.description?.contains(text, ignoreCase = true) ?: false
  }

  private fun searchedProducts( text:String): List<Product> {
    return sampleProducts
      .filter(filterByNameAndDescription(text)) + dao.products().value.filter(filterByNameAndDescription(text))
  }
}