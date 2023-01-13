package br.com.lucolimac.aluvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.lucolimac.aluvery.dao.ProductDao
import br.com.lucolimac.aluvery.ui.components.AluveryApp
import br.com.lucolimac.aluvery.ui.screens.HomeScreen

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
                HomeScreen(products)
            }
        }
    }
}