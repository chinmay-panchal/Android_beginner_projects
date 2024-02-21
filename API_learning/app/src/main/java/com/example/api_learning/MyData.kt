package com.example.api_learning

data class MyData(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)