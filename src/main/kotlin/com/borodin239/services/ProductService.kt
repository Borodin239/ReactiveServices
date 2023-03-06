package com.borodin239.services

import com.borodin239.model.Product
import com.borodin239.repository.ProductRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class ProductService(
    val productRepository: ProductRepository
) {

    fun createProduct(price: Double, name: String): Mono<UUID> {
        return productRepository.save(Product(UUID.randomUUID(), name, price))
            .map { it.id }
    }
}