package com.example.testcompose.ui.states

import com.example.testcompose.model.Product

data class HomeViewUiState(
  val sections: Map<String, List<Product>> = emptyMap(),
  val searchedProducts: List<Product> = emptyList(),
  val searchText: String = "",
  val onSearchChange: (String) -> Unit = {}
) {

  fun isShowSections(): Boolean {
    return searchText.isBlank()
  }
}