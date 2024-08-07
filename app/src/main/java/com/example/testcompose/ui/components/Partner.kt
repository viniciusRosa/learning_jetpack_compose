package com.example.testcompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.testcompose.R
import com.example.testcompose.model.Shop

@Composable
fun Partner(
  shop: Shop,
  modifier: Modifier = Modifier,
) {
  Surface(
    modifier,
  ) {
    Column(
      Modifier
        .heightIn(150.dp, 200.dp)
        .width(100.dp)
    ) {
      val imageSize = 100.dp
      AsyncImage(
        model = shop.logo,
        contentDescription = null,
        Modifier
          .size(imageSize)
          .clip(shape = CircleShape),
        contentScale = ContentScale.Crop,
        placeholder = painterResource(id = R.drawable.ic_launcher_background)
      )
      Text(
        text = shop.name,
        fontSize = 16.sp,
        maxLines = 2,
        textAlign = TextAlign.Center,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
          .padding(8.dp)
          .fillMaxWidth()

      )
    }
  }
}

@Preview
@Composable
private fun PartnerPreview() {
  Partner(shop = Shop(
    name = "Vini",
    logo = "https://images.pexels.com/photos/1855214/pexels-photo-1855214.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
  ))
}