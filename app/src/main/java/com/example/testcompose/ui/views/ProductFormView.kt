package com.example.testcompose.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.testcompose.R
import com.example.testcompose.model.Product
import com.example.testcompose.ui.states.ProductFormUiState
import com.example.testcompose.ui.theme.TestComposeTheme
import com.example.testcompose.ui.viewmodels.ProductFormViewModel

@Composable
fun ProductFormScreen(
  viewModel: ProductFormViewModel,
  onSaveClick: (Product) -> Unit = {}
) {
  val state by viewModel.uiState.collectAsState()
  ProductFormScreen(
    state = state,
    onSaveClick = {
      viewModel.save()
    }
  )
}

@Composable
fun ProductFormScreen(
  state: ProductFormUiState = ProductFormUiState(),
  onSaveClick: () -> Unit = {}
) {
  val url = state.url
  val name = state.name
  val price = state.price
  val description = state.description
  Column(
    Modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp)
      .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    Spacer(modifier = Modifier)
    Text(
      text = "Criando o produto",
      Modifier.fillMaxWidth(),
      fontSize = 28.sp,
    )
    if (state.isShowPreview) {
      AsyncImage(
        model = url, contentDescription = null,
        Modifier
          .fillMaxWidth()
          .height(200.dp),
        contentScale = ContentScale.Crop,
        placeholder = painterResource(id = R.drawable.ic_launcher_background),
        error = painterResource(id = R.drawable.ic_launcher_background)
      )
    }
    TextField(
      value = url,
      onValueChange = state.onUrlChange,
      Modifier.fillMaxWidth(),
      label = {
        Text(text = "Url da imagem")
      },
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Uri,
        imeAction = ImeAction.Next
      )
    )
    TextField(
      value = name,
      onValueChange = state.onNameChange,
      Modifier.fillMaxWidth(),
      label = {
        Text(text = "Nome")
      },
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Next,
        capitalization = KeyboardCapitalization.Words
      )
    )

    TextField(
      value = price,
      onValueChange = state.onPriceChange,
      Modifier.fillMaxWidth(),
      label = {
        Text(text = "Preço")
      },
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Decimal,
        imeAction = ImeAction.Next
      )
    )
    TextField(
      value = description,
      onValueChange = state.onDescriptionChange,
      Modifier
        .fillMaxWidth()
        .heightIn(min = 100.dp),
      label = {
        Text(text = "Descrição")
      },
      keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        capitalization = KeyboardCapitalization.Sentences
      )
    )
    Button(
      onClick = onSaveClick,
      Modifier.fillMaxWidth(),
    ) {
      Text(text = "Salvar")
    }
    Spacer(modifier = Modifier)
  }
}

@Preview
@Composable
fun ProductFormScreenPreview() {
  TestComposeTheme {
    Surface {
      ProductFormScreen(state = ProductFormUiState())
    }
  }
}

@Preview
@Composable
fun ProductFormScreenFilledPreview() {
  TestComposeTheme {
    Surface {
      ProductFormScreen(
        state = ProductFormUiState(
          url = "url teste",
          name = "nome teste",
          price = "123",
          description = "descrição teste"
        )
      )
    }
  }
}