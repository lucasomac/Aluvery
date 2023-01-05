package br.com.lucolimac.aluvery.utils

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

object Extensions {
    fun BigDecimal.toBrazilianCurrency(): String {
        return NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(this)
    }
}