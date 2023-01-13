package br.com.lucolimac.aluvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import br.com.lucolimac.aluvery.dao.ProductDao
import br.com.lucolimac.aluvery.sample.sampleCandies
import br.com.lucolimac.aluvery.sample.sampleDrinks
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
                dao.products()
                val sections = mapOf(
                    "All Products" to dao.products(),
                    "Promoções" to sampleDrinks + sampleCandies,
                    "Doces" to sampleCandies,
                    "Bebidas" to sampleDrinks
                )
                val state = remember { HomeScreenUiState() }
                HomeScreen(sections = sections, state)
            }
        }
    }
}
