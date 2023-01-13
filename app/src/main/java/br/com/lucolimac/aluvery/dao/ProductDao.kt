package br.com.lucolimac.aluvery.dao

import br.com.lucolimac.aluvery.sample.sampleProducts


class ProductDao {

    companion object {
        private val products = sampleProducts.toMutableList()
    }

    fun products() = products.toList()
}