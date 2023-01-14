package br.com.lucolimac.aluvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import br.com.lucolimac.aluvery.dao.ProductDao
import br.com.lucolimac.aluvery.ui.components.AluveryApp
import br.com.lucolimac.aluvery.ui.screens.HomeScreen
import br.com.lucolimac.aluvery.ui.viewmodel.HomeScreenViewModel

class MainActivity : ComponentActivity() {
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
                val viewModel by viewModels<HomeScreenViewModel>()
                HomeScreen(viewModel)
            }
        }
    }
}