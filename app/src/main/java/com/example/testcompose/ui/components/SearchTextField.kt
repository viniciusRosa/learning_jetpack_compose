package com.example.testcompose.ui.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.example.testcompose.model.Product
import com.example.testcompose.ui.theme.TestComposeTheme
import java.math.BigDecimal

@Composable
fun SearchTextField(
  searchText: String,
  onSearchChange: (String) -> Unit) {

  OutlinedTextField(
    value = searchText,
    onValueChange = { newValue ->
      Log.i("HomeView", "TextField = $newValue")
      onSearchChange(newValue)
    },
    Modifier
      .padding(16.dp)
      .fillMaxWidth(),
    shape = RoundedCornerShape(50),
    leadingIcon = {
      Icon(Icons.Default.Search, contentDescription = "")
    },
    label = {
      Text(text = "Produto")
    },
    placeholder = {
      Text(text = "O que vc procura?")
    }
  )
}

@Preview
@Composable
private fun SearchTextFieldPreview() {
  TestComposeTheme {
    Surface {
      SearchTextField("teste", {})
    }
  }
}