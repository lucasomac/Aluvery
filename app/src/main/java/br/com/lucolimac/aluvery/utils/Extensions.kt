package br.com.lucolimac.aluvery.utils

import br.com.lucolimac.aluvery.utils.Constants.LOCALE_PT_BR
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

object Extensions {
    fun BigDecimal.toBrazilianCurrency(): String {
        return NumberFormat.getCurrencyInstance(LOCALE_PT_BR).format(this)
    }
}