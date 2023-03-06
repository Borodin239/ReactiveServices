package com.borodin239.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Product(
    @Id val id: UUID,
    val name: String,
    val priceInRubles: Double,
)