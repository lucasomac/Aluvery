package br.com.lucolimac.aluvery.ui.states

import androidx.compose.runtime.mutableStateOf
import br.com.lucolimac.aluvery.sample.sampleProducts

class HomeScreenUiState(searchText: String = "") {
    var text = mutableStateOf(searchText)
        private set
    val searchedProducts
        get() = if (text.value.isNotBlank()) {
            sampleProducts.filter {
                it.name.contains(text.value, true) || it.description?.contains(
                    text.value,
                    ignoreCase = true,
                ) ?: false
            }
        } else emptyList()
    val onSearchChange: (String) -> Unit = {
        text.value = it
    }

    fun isShowSection(): Boolean {
        return text.value.isBlank() || text.value.isEmpty()
    }

}