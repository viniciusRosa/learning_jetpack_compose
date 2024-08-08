package com.example.testcompose.DAO

import androidx.compose.runtime.mutableStateListOf
import com.example.testcompose.model.Product
import com.example.testcompose.ui.components.sampleProducts

class ProductDao {
  companion object {
    private val products = mutableStateListOf<Product>(
//      *sampleProducts.toTypedArray()
    )
  }

  fun products() = products.toList()

  fun save(product: Product) {
    products.add(product)
  }
}