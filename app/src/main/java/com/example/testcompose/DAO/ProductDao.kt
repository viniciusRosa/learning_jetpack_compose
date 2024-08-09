package com.example.testcompose.DAO

import androidx.compose.runtime.mutableStateListOf
import com.example.testcompose.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDao {
  companion object {
    private val products = MutableStateFlow<List<Product>>(
      emptyList()
    )
  }

  fun products(): StateFlow<List<Product>> = products.asStateFlow()

  fun save(product: Product) {
    products.value = products.value + product
  }
}