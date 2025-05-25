package com.lelo.d4c.models

data class Product(
    val title: String,
    val subtitle: String,
    val imageRes: Int,
    val isBestSeller: Boolean,
    val isInStock: Boolean,
    val price: String,
    val originalPrice: String,
    val rating: Float,
    val reviewCount: Int
)

