package br.com.lucolimac.aluvery.domain.entity

import androidx.annotation.DrawableRes
import br.com.lucolimac.aluvery.R
import br.com.lucolimac.aluvery.utils.Extensions.toBrazilianCurrency
import java.math.BigDecimal

data class Product(
    val name: String,
    val price: BigDecimal,
    @DrawableRes val image: Int = R.drawable.hamburger,
) {
    val priceFormatted: String
        get() = price.toBrazilianCurrency()
}
