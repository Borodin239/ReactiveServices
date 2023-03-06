package com.borodin239.repository

import com.borodin239.model.Currency
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface CurrencyRepository : ReactiveCrudRepository<Currency, String> {

    fun findByName(name: String): Mono<Currency>

    fun existsByName(name: String): Mono<Boolean>

}