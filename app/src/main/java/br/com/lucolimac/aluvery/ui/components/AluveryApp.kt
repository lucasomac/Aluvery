package br.com.lucolimac.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.lucolimac.aluvery.domain.entity.Product
import br.com.lucolimac.aluvery.domain.entity.Section
import br.com.lucolimac.aluvery.sample.sampleSections
import br.com.lucolimac.aluvery.ui.theme.AluveryTheme
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen16

@Composable
fun AluveryApp(sections: Map<String, List<Product>>) {
    AluveryTheme {
        Surface() {
            LazyColumn(
                modifier = Modifier.padding(horizontal = Dimen16),
                verticalArrangement = Arrangement.spacedBy(Dimen16),
                contentPadding = PaddingValues(
                    vertical = Dimen16
                ),
            ) {
                item {
                    sections.forEach {
                        ProductsSection(section = Section(it.key, it.value))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AluveryAppPreview() {
    AluveryApp(sampleSections)
}