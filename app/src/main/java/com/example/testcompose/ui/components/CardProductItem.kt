package com.example.testcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.testcompose.R
import com.example.testcompose.extensions.toBrazilianCurrency
import com.example.testcompose.model.Product
import com.example.testcompose.ui.theme.TestComposeTheme
import java.math.BigDecimal

@Composable
fun CardProductItem(
  product: Product,
  modifier: Modifier = Modifier,
  isExpanded: Boolean = false
) {

  var expended by rememberSaveable {
    mutableStateOf(isExpanded)
  }
  Card(
    modifier
      .fillMaxWidth()
      .heightIn(150.dp)
      .clickable { !expended }
  ) {
    Column {
      AsyncImage(
        model = product.image,
        contentDescription = null,
        Modifier
          .fillMaxWidth()
          .height(100.dp),
        placeholder = painterResource(id = R.drawable.ic_launcher_background),
        contentScale = ContentScale.Crop
      )
      Column(
        Modifier
          .fillMaxWidth()
          .background(MaterialTheme.colorScheme.primary)
          .padding(16.dp)
      ) {
        Text(
          text = product.name,
          color = Color(0xFFFFFFFF)
        )
        Text(
          text = product.price.toBrazilianCurrency(),
          color = Color(0xFFFFFFFF)
        )
      }

      if (expended) {
        product.description?.let {
          Text(
            text = product.description,
            Modifier
              .padding(16.dp)
          )
        }
      }
    }
  }
}

@Preview
@Composable
private fun CardProductItemPreview() {
  TestComposeTheme {
    Surface {
      CardProductItem(
        product = Product(
          name = "teste",
          price = BigDecimal("14.99"),

          ),
      )
    }
  }
}

@Preview
@Composable
private fun CardProductItemWithDescriptionPreview() {
  TestComposeTheme {
    Surface {
      CardProductItem(
        product = Product(
          name = "teste",
          price = BigDecimal("14.99"),
          description = LoremIpsum(50).values.first(),
        ),
        isExpanded = true
      )
    }
  }
}