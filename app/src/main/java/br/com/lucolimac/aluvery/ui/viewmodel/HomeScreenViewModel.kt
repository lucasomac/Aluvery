package br.com.lucolimac.aluvery.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import br.com.lucolimac.aluvery.dao.ProductDao
import br.com.lucolimac.aluvery.domain.entity.Product
import br.com.lucolimac.aluvery.sample.sampleCandies
import br.com.lucolimac.aluvery.sample.sampleDrinks
import br.com.lucolimac.aluvery.sample.sampleProducts
import br.com.lucolimac.aluvery.ui.states.HomeScreenUiState

class HomeScreenViewModel : ViewModel() {
    private val dao = ProductDao()
    var uiState: HomeScreenUiState by mutableStateOf(
        HomeScreenUiState(sections = mapOf(
            "All Products" to dao.products(),
            "Promoções" to sampleDrinks + sampleCandies,
            "Doces" to sampleCandies,
            "Bebidas" to sampleDrinks
        ), onSearchChange = {
            uiState = uiState.copy(searchText = it, searchedProducts = searchedProducts(it))
        })
    )
        private set

    private fun containsInNameOrDescription(text: String): (Product) -> Boolean = {
        it.name.contains(text, true) || it.description?.contains(
            text,
            ignoreCase = true,
        ) ?: false
    }

    private fun searchedProducts(text: String): List<Product> {
        return if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription(text)) + dao.products().filter(
                containsInNameOrDescription(text)
            )
        } else emptyList()
    }

    fun findProducts() {
        uiState = uiState.copy(
            sections = mapOf(
                "Todos os produtos" to dao.products() + sampleProducts.random(),
                "Promoções" to sampleDrinks + sampleCandies,
                "Doces" to sampleCandies,
                "Bebidas" to sampleDrinks
            )
        )
    }
}