package com.borodin239.view

import java.util.UUID


data class ProductsView(
    val id: UUID,
    val name: String,
    val price: Double
)