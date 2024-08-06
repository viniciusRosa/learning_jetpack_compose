package com.example.testcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcompose.R
import com.example.testcompose.extensions.toBrazilianCurrency
import com.example.testcompose.model.Product
import com.example.testcompose.ui.theme.Pink40
import com.example.testcompose.ui.theme.Teal200
import java.math.BigDecimal

@Composable
fun ProductItem(product: Product) {
  Surface(
    shape = RoundedCornerShape(15.dp), shadowElevation = 4.dp
  ) {
    Column(
      Modifier
        .heightIn(250.dp, 280.dp)
        .width(200.dp)
    ) {
      val imageSize = 100.dp
      Box(
        modifier = Modifier
          .height(imageSize)
          .fillMaxWidth()
          .background(brush = Brush.horizontalGradient(colors = listOf(Pink40, Teal200)))
      ) {
        Image(
          modifier = Modifier
            .size(imageSize)
            .offset(y = imageSize / 2)
            .clip(shape = CircleShape)
            .align(Alignment.BottomCenter),
          painter = painterResource(id = product.image),
          contentDescription = "imagem",
          contentScale = ContentScale.Crop
        )
      }
      Spacer(modifier = Modifier.height(imageSize / 2))
      Column(Modifier.padding(16.dp)) {
        Text(
          text = product.name,
          modifier = Modifier.padding(bottom = 8.dp),
          fontSize = 18.sp,
          fontWeight = FontWeight(700),
          maxLines = 2,
          overflow = TextOverflow.Ellipsis
        )
        Text(
          text = product.price.toBrazilianCurrency(), fontSize = 14.sp, fontWeight = FontWeight(400)
        )
      }
    }

  }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
  ProductItem(
    Product(
      name = LoremIpsum(50).values.first(),
      price = BigDecimal("11.99"),
      image = R.drawable.ic_launcher_background
    )
  )
}