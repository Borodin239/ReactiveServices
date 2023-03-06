package com.borodin239.view

import com.borodin239.model.Product
import org.springframework.stereotype.Component

@Component
class ProductsViewMapper {

    fun toViewWithAnotherRate(product: Product, rate: Double): ProductsView {
        return ProductsView(
            id = product.id,
            name = product.name,
            price = product.priceInRubles * rate
        )
    }
}