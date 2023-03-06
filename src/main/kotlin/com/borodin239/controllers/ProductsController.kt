package com.borodin239.controllers

import com.borodin239.services.StorageService
import com.borodin239.services.ProductService
import com.borodin239.view.ProductsView
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/api/goods")
class ProductsController(
    val storageService: StorageService,
    val productService: ProductService,
) {

    @PostMapping
    fun create(@RequestParam price: Double, @RequestParam name: String): Mono<UUID> {
        return productService.createProduct(price, name)
    }

    @GetMapping("/all/user/{userId}")
    fun getAssortment(@PathVariable userId: UUID): Flux<ProductsView> {
        return storageService.viewForUser(userId)
    }

}