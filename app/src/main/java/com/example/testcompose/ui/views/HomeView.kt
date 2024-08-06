package com.example.testcompose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcompose.ui.components.ProductSection
import com.example.testcompose.ui.components.sampleProducts

@Composable
fun HomeView() {
  Column(
    Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    Spacer(Modifier)
    ProductSection("Promo", sampleProducts)
    ProductSection("Lanches", sampleProducts)
    ProductSection("Bebidas", sampleProducts)
    Spacer(Modifier)
  }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeViewPreview() {
  HomeView()
}