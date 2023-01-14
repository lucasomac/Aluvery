package br.com.lucolimac.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.lucolimac.aluvery.domain.entity.PartnerSectionData
import br.com.lucolimac.aluvery.domain.entity.ProductSectionData
import br.com.lucolimac.aluvery.sample.sampleSections
import br.com.lucolimac.aluvery.sample.sampleShopSections
import br.com.lucolimac.aluvery.ui.components.SearchTextField
import br.com.lucolimac.aluvery.ui.components.product.CardProductItem
import br.com.lucolimac.aluvery.ui.components.section.PartnersSection
import br.com.lucolimac.aluvery.ui.components.section.ProductsSection
import br.com.lucolimac.aluvery.ui.states.HomeScreenUiState
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen16
import br.com.lucolimac.aluvery.ui.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {

    val state = viewModel.uiState
    HomeScreen(state)
}

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState()
) {
    Column {
        val imputedText = state.searchText
        val filteredProducts = state.searchedProducts
        val sections = remember {
            state.sections
        }
        SearchTextField(imputedText, doSearchOnTextChange = state.onSearchChange)
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(Dimen16),
            contentPadding = PaddingValues(bottom = Dimen16),
        ) {
            if (state.isShowSection()) {
                sections.forEach {
                    item {
                        ProductsSection(productSectionData = ProductSectionData(it.key, it.value))
                    }
                }
                sampleShopSections.forEach {
                    item {
                        PartnersSection(partnerSectionData = PartnerSectionData(it.key, it.value))
                    }
                }
            } else {
                items(filteredProducts) {
                    CardProductItem(product = it, Modifier.padding(horizontal = Dimen16))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(HomeScreenUiState(sections = sampleSections))
}

@Preview
@Composable
fun HomeScreenWithSearchTextPreview() {
    HomeScreen(
        state = HomeScreenUiState(
            searchText = "a", sections = sampleSections
        ),
    )
}