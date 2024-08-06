package com.example.testcompose.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcompose.R
import com.example.testcompose.model.Product
import java.math.BigDecimal

@Composable
fun ProductSection(sectionName: String, products: List<Product>) {
  Column {
    Text(
      text = sectionName,
      Modifier.padding(start = 16.dp, end = 16.dp),
      fontSize = 20.sp,
      fontWeight = FontWeight(400)
    )
    Row(
      Modifier
        .padding(
          top = 8.dp,
        )
        .fillMaxWidth()
        .horizontalScroll(rememberScrollState()),

      horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      Spacer(Modifier)
      for(productItem in products) {
        ProductItem(product = productItem)
      }
      Spacer(Modifier)
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun ProductSectionPreview() {
  ProductSection("Teste", products = sampleProducts)
}

val sampleProducts = listOf(
  Product(
    name = LoremIpsum(50).values.first(),
    price = BigDecimal("11.99"),
    image = R.drawable.ic_launcher_background
  ),
  Product(
    name = LoremIpsum(50).values.first(),
    price = BigDecimal("15.99"),
    image = R.drawable.ic_launcher_background
  ),
  Product(
    name = LoremIpsum(50).values.first(),
    price = BigDecimal("111.99"),
    image = R.drawable.ic_launcher_background
  )
)