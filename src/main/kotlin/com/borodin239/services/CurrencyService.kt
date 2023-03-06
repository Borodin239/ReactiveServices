package com.borodin239.services

import com.borodin239.exceptions.CurrencyNotFoundException
import com.borodin239.model.Currency
import com.borodin239.repository.CurrencyRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Service
class CurrencyService(
    val currencyRepository: CurrencyRepository
) {

    fun create(name: String, priceInRubles: Double): Mono<Void> {
        return currencyRepository.save(Currency(name, priceInRubles)).then()
    }

    fun getCurrency(name: String): Mono<Currency> {
        return currencyRepository.findByName(name)
            .switchIfEmpty { Mono.error { CurrencyNotFoundException(name) } }
    }

}