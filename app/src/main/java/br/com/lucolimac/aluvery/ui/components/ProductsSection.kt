package br.com.lucolimac.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.lucolimac.aluvery.domain.entity.Section
import br.com.lucolimac.aluvery.sample.sampleProducts
import br.com.lucolimac.aluvery.ui.theme.AluveryTheme
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen16
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen8

@Composable
fun ProductsSection(section: Section) {
    Column {
        Text(
            text = section.title,
            Modifier.padding(
                start = Dimen16,
                end = Dimen16
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight.W400,
            lineHeight = 24.sp,
        )
        LazyRow(
            modifier = Modifier
                .padding(top = Dimen8)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Dimen16),
            contentPadding = PaddingValues(horizontal = Dimen16)
        ) {
            items(section.products) {
                ProductItem(product = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsSectionPreview() {
    AluveryTheme {
        Surface {
            ProductsSection(section = Section("Section", sampleProducts))
        }
    }
}