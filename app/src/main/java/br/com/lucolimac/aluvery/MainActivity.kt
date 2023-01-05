package br.com.lucolimac.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.lucolimac.aluvery.domain.entity.Product
import br.com.lucolimac.aluvery.domain.entity.Section
import br.com.lucolimac.aluvery.ui.components.AluveryApp
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryApp(
                sections = listOf(
                    Section(
                        "Promoções", listOf(
                            Product("Hamburger", BigDecimal(14.50)),
                            Product("Pizza", BigDecimal(59.34), R.drawable.pizza),
                            Product("Fries", BigDecimal(39.90), R.drawable.fries),
                        )
                    ), Section(
                        "Doces", listOf(
                            Product("Hamburger", BigDecimal(14.50)),
                            Product("Pizza", BigDecimal(59.34), R.drawable.pizza),
                            Product("Fries", BigDecimal(39.90), R.drawable.fries),
                        )
                    ), Section(
                        "Salgados", listOf(
                            Product("Hamburger", BigDecimal(14.50)),
                            Product("Pizza", BigDecimal(59.34), R.drawable.pizza),
                            Product("Fries", BigDecimal(39.90), R.drawable.fries),
                        )
                    )
                )
            )
        }
    }
}
