package br.com.lucolimac.aluvery.ui.states

import br.com.lucolimac.aluvery.domain.entity.Product

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchedProducts: List<Product> = emptyList(),
    var searchText: String = "",
    val onSearchChange: (String) -> Unit = {}
) {
    fun isShowSection(): Boolean {
        return searchText.isBlank() || searchText.isEmpty()
    }
}