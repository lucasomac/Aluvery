package br.com.lucolimac.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import br.com.lucolimac.aluvery.domain.entity.Product
import br.com.lucolimac.aluvery.sample.sampleProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class ProductDao {
    companion object {
        private val products = MutableStateFlow<List<Product>>(emptyList())
    }

    fun products(): StateFlow<List<Product>> = products.asStateFlow()

    fun save(product: Product) {
        products.value = products.value + product
    }

}