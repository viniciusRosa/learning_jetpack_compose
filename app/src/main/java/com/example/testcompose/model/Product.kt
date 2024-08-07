package com.example.testcompose.model

import java.math.BigDecimal

class Product(
  val name: String,
  val price: BigDecimal,
  val image: String? = null
  )