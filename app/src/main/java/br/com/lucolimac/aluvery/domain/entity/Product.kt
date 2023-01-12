package br.com.lucolimac.aluvery.domain.entity

import br.com.lucolimac.aluvery.utils.Extensions.toBrazilianCurrency
import java.math.BigDecimal

data class Product(
    val name: String,
    val price: BigDecimal,
    val image: String? = null,
) {
    val priceFormatted: String
        get() = price.toBrazilianCurrency()
}
