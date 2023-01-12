package br.com.lucolimac.aluvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import br.com.lucolimac.aluvery.ui.screens.ProductFormScreen
import br.com.lucolimac.aluvery.ui.theme.AluveryTheme

class ProductFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                AluveryTheme {
                    Surface {
                        ProductFormScreen()
                    }
                }
            }
        }
    }
}