package com.example.testcompose.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.testcompose.model.Product
import com.example.testcompose.ui.theme.TestComposeTheme
import java.math.BigDecimal
class ProductFormActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TestComposeTheme {
        Surface {
          ProductFormSreen()
        }
      }
    }
  }
}

@Composable
fun ProductFormSreen(modifier: Modifier = Modifier) {
  Column(
    modifier
      .fillMaxSize()
      .padding(16.dp)
      .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    Text(
      text = "Criar Produto",
      modifier = Modifier.fillMaxWidth(),
      fontSize = 28.sp
    )

    var url by remember {
      mutableStateOf("")
    }

    if(url.isNotBlank()) {
      AsyncImage(
        model = url,
        contentDescription = null,
        modifier = Modifier
          .fillMaxWidth()
          .height(200.dp),
        contentScale = ContentScale.Crop,
        placeholder = painterResource(id = com.example.testcompose.R.drawable.ic_launcher_background),
        error = painterResource(id = com.example.testcompose.R.drawable.ic_launcher_background)
      )
    }

    OutlinedTextField(
      value = url,
      onValueChange = { url = it },
      Modifier.fillMaxWidth(),
      label = {
        Text(text = "Url")
      }
    )

    var name by remember {
      mutableStateOf("")
    }
    OutlinedTextField(
      value = name,
      onValueChange = { name = it },
      Modifier.fillMaxWidth(),
      label = {
        Text(text = "Nome")
      })

    var price by remember {
      mutableStateOf("")
    }
    OutlinedTextField(
      value = price,
      onValueChange = { price = it },
      Modifier.fillMaxWidth(),
      label = {
        Text(text = "Preço")
      })

    var description by remember {
      mutableStateOf("")
    }
    OutlinedTextField(
      value = description,
      onValueChange = { description = it },
      Modifier
        .fillMaxWidth()
        .heightIn(100.dp),
      label = {
        Text(text = "Descrição")
      })

    Button(
      onClick = {
        val converdedPrice = try {
          BigDecimal(price)
        } catch (error: NumberFormatException) {
          BigDecimal.ZERO
        }
        val product = Product(
          name = name,
          price = converdedPrice,
          description = description,
          image = url
        )

        Log.i("ProductFormActivity", "ProductFormSreen: $product")
      },
      modifier = Modifier.fillMaxWidth()
      ) {
      Text(text = "Salvar")
    }

  }
}

@Preview
@Composable
private fun ProductFormScreenView() {
  TestComposeTheme {
    Surface {
      ProductFormSreen()
    }
  }
}