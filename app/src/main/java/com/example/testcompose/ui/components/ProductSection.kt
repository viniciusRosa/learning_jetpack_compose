package com.example.testcompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcompose.model.Product
import com.example.testcompose.model.Shop
import com.example.testcompose.ui.theme.TestComposeTheme
import java.math.BigDecimal

@Composable
fun ProductSection(
  sectionName: String,
  products: List<Product>,
  modifier: Modifier = Modifier,
) {
  Column(modifier) {
    Text(
      text = sectionName,
      Modifier.padding(start = 16.dp, end = 16.dp),
      fontSize = 20.sp,
      fontWeight = FontWeight(400)
    )
    LazyRow(
      Modifier
        .padding(
          top = 8.dp,
        )
        .fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(16.dp),
      contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
      items(products) { productItem ->
        ProductItem(product = productItem)
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun ProductSectionPreview() {
  TestComposeTheme {
    Surface {
      ProductSection("Teste", products = sampleProducts)
    }
  }
}

val sampleCandies = listOf(
  Product(
    name = "Chocolate",
    price = BigDecimal("3.99"),
    image = "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg",
  ),
  Product(
    name = "Sorvete",
    price = BigDecimal("5.99"),
    image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
  ),
  Product(
    name = "Bolo",
    price = BigDecimal("11.99"),
    image = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",
  )
)

val sampleDrinks = listOf(
  Product(
    name = "Cerveja",
    price = BigDecimal("5.99"),
    image = "https://images.pexels.com/photos/1552630/pexels-photo-1552630.jpeg",
    description = LoremIpsum(20).values.first()

  ),
  Product(
    name = "Refrigerante",
    price = BigDecimal("4.99"),
    image = "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg",
    description = LoremIpsum(20).values.first()
  ),
  Product(
    name = "Suco",
    price = BigDecimal("7.99"),
    image = "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg",
    description = LoremIpsum(20).values.first()
  ),
  Product(
    name = "Água",
    price = BigDecimal("2.99"),
    image = "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg"
  )
)

val sampleProducts: List<Product> = listOf(
  Product(
    name = LoremIpsum(50).values.first(),
    price = BigDecimal("11.99"),
    image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
  ),
  Product(
    name = LoremIpsum(50).values.first(),
    price = BigDecimal("15.99"),
    image = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg"
  ),
  Product(
    name = LoremIpsum(50).values.first(),
    price = BigDecimal("111.99"),
    image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg"
  ), *sampleDrinks.toTypedArray(), *sampleCandies.toTypedArray()
)

val sampleSections = mapOf(
  "Promoções" to sampleProducts,
  "Doces" to sampleCandies,
  "Bebidas" to sampleDrinks
)

val sampleShops: List<Shop> = listOf(
  Shop(
    name = "Carrinho SuperMercado",
    logo = "https://images.pexels.com/photos/264547/pexels-photo-264547.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
  ),
  Shop(
    name = "Padaria",
    logo = "https://images.pexels.com/photos/1855214/pexels-photo-1855214.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
  ),
  Shop(
    name = "Floricultura",
    logo = "https://images.pexels.com/photos/2111192/pexels-photo-2111192.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
  ),
  Shop(
    name = "Loja de Roupas",
    logo = "https://images.pexels.com/photos/102129/pexels-photo-102129.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
  ),
  Shop(
    name = "Hotéis",
    logo = "https://images.pexels.com/photos/237272/pexels-photo-237272.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
  ),
)
val sampleShopSections = mapOf(
  "Lojas Parceiras" to sampleShops
)