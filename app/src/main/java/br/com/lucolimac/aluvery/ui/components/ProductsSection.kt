package br.com.lucolimac.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.lucolimac.aluvery.R
import br.com.lucolimac.aluvery.domain.entity.Product
import br.com.lucolimac.aluvery.domain.entity.Section
import java.math.BigDecimal

@Composable
fun ProductsSection(section: Section) {
    Column {
        Text(
            text = section.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.W400,
            lineHeight = 24.sp,
        )
        Row {
            Spacer(modifier = Modifier)
            LazyRow(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(section.products) {
                    ProductItem(product = it)
                }
            }
            Spacer(modifier = Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsSectionPreview() {
    ProductsSection(
        Section(
            "Promoções", listOf(
                Product("Hamburger", BigDecimal(14.50)),
                Product("Pizza", BigDecimal(59.34), R.drawable.pizza),
                Product("Fries", BigDecimal(39.90), R.drawable.fries),
            )
        )
    )
}