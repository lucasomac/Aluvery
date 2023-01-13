package br.com.lucolimac.aluvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import br.com.lucolimac.aluvery.dao.ProductDao
import br.com.lucolimac.aluvery.domain.entity.Product
import br.com.lucolimac.aluvery.sample.sampleCandies
import br.com.lucolimac.aluvery.sample.sampleDrinks
import br.com.lucolimac.aluvery.sample.sampleProducts
import br.com.lucolimac.aluvery.ui.components.AluveryApp
import br.com.lucolimac.aluvery.ui.screens.HomeScreen
import br.com.lucolimac.aluvery.ui.states.HomeScreenUiState

class MainActivity : ComponentActivity() {
    private val dao = ProductDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryApp(onFabClick = {
                startActivity(
                    Intent(
                        this, ProductFormActivity::class.java
                    )
                )
            }) {
                val products = dao.products()
                val sections = mapOf(
                    "All Products" to products,
                    "Promoções" to sampleDrinks + sampleCandies,
                    "Doces" to sampleCandies,
                    "Bebidas" to sampleDrinks
                )
                var text by remember { mutableStateOf("") }
                fun containsInNameOrDescription(): (Product) -> Boolean = {
                    it.name.contains(text, true) || it.description?.contains(
                        text,
                        ignoreCase = true,
                    ) ?: false
                }

                val searchedProducts = remember(text, products) {
                    if (text.isNotBlank()) {
                        sampleProducts.filter(containsInNameOrDescription()) + products.filter(
                            containsInNameOrDescription()
                        )
                    } else emptyList()
                }
                val state = remember(products, text) {
                    HomeScreenUiState(sections,
                        searchedProducts,
                        searchText = text,
                        onSearchChange = {
                            text = it
                        })
                }
                HomeScreen(state)
            }
        }
    }
}
