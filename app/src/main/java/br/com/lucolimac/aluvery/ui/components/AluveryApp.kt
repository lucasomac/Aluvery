package br.com.lucolimac.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.lucolimac.aluvery.R
import br.com.lucolimac.aluvery.domain.entity.Product
import br.com.lucolimac.aluvery.domain.entity.Section
import br.com.lucolimac.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal

@Composable
fun AluveryApp(sections: List<Section>) {
    AluveryTheme {
        Surface() {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(
                    vertical = 16.dp
                ),
            ) {
                item {
                    sections.forEach {
                        ProductsSection(section = it)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AluveryAppPreview() {
    AluveryApp(
        listOf(
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