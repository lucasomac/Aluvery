package br.com.lucolimac.aluvery.ui.components

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import br.com.lucolimac.aluvery.domain.entity.Product
import br.com.lucolimac.aluvery.ui.screens.HomeScreen
import br.com.lucolimac.aluvery.ui.theme.AluveryTheme

@Composable
fun AluveryApp(sections: Map<String, List<Product>>) {
    AluveryTheme {
        Surface {
            HomeScreen(sections = sections)
        }
    }
}