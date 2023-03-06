package com.borodin239.repository

import com.borodin239.model.Product
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.UUID

interface ProductRepository : ReactiveCrudRepository<Product, UUID>