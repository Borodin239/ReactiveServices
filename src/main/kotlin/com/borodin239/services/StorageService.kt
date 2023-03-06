package com.borodin239.services

import com.borodin239.model.Currency
import com.borodin239.repository.ProductRepository
import com.borodin239.view.ProductsView
import com.borodin239.view.ProductsViewMapper
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.*

@Service
class StorageService(
    val productRepository: ProductRepository,
    val productsViewMapper: ProductsViewMapper,
    val currencyService: CurrencyService,
    val userService: UserService,
) {

    fun viewForUser(userId: UUID): Flux<ProductsView> {
        return userService.getUser(userId).flatMap { user -> currencyService.getCurrency(user.currencyName) }
            .flatMapMany { currencyRate -> mapGoodWithRate(currencyRate) }
    }

    private fun mapGoodWithRate(currencyRate: Currency) = productRepository.findAll()
        .map { good -> productsViewMapper.toViewWithAnotherRate(good, currencyRate.inRubles) }

}