package br.com.lucolimac.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.lucolimac.aluvery.domain.entity.Product
import br.com.lucolimac.aluvery.domain.entity.Section
import br.com.lucolimac.aluvery.sample.sampleProducts
import br.com.lucolimac.aluvery.sample.sampleSections
import br.com.lucolimac.aluvery.ui.components.CardProductItem
import br.com.lucolimac.aluvery.ui.components.ProductsSection
import br.com.lucolimac.aluvery.ui.components.SearchTextField
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen16

@Composable
fun HomeScreen(sections: Map<String, List<Product>>, searchText: String = "") {
    Column {
        var imputedText by remember { mutableStateOf(searchText) }
        SearchTextField(imputedText, doSearchOnTextChange = { imputedText = it })

        val searchedProducts = remember(imputedText) {
            if (imputedText.isNotEmpty()) sampleProducts.filter {
                it.name.contains(
                    imputedText, true
                ) || it.description?.contains(imputedText, true) ?: false
            }
            else emptyList()
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(Dimen16),
            contentPadding = PaddingValues(bottom = Dimen16),
        ) {
            if (imputedText.isBlank() || imputedText.isEmpty()) {
                sections.forEach {
                    item {
                        ProductsSection(section = Section(it.key, it.value))
                    }
                }
            } else {
                items(searchedProducts) {
                    CardProductItem(product = it, Modifier.padding(horizontal = Dimen16))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(sampleSections)
}