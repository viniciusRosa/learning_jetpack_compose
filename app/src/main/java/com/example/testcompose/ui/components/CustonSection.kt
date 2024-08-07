package com.example.testcompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustonSection(
  title: @Composable () -> Unit, 
  content: @Composable () -> Unit,
  modifier: Modifier = Modifier) {
  Column(modifier) {
    title()
    Spacer(modifier = Modifier.height(16.dp))
    content()
  }
}