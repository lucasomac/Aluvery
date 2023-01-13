package br.com.lucolimac.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import br.com.lucolimac.aluvery.domain.entity.Product
import br.com.lucolimac.aluvery.sample.sampleProducts


class ProductDao {

    companion object {
        private val products = mutableStateListOf(*sampleProducts.toTypedArray())
    }

    fun products() = products.toList()
    fun save(product: Product) {
        products.add(product)
    }
}