package br.com.lucolimac.aluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import br.com.lucolimac.aluvery.dao.ProductDao
import br.com.lucolimac.aluvery.ui.screens.ProductFormScreen
import br.com.lucolimac.aluvery.ui.theme.AluveryTheme
import br.com.lucolimac.aluvery.ui.viewmodel.ProductFormScreenViewModel

class ProductFormActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    val viewModel: ProductFormScreenViewModel by viewModels()
                    ProductFormScreen(viewModel = viewModel, onSaveClick = {
                        finish()
                    })
                }
            }
        }
    }
}