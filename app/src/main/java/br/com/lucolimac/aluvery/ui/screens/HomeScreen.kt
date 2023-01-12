package br.com.lucolimac.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import br.com.lucolimac.aluvery.domain.entity.Product
import br.com.lucolimac.aluvery.domain.entity.Section
import br.com.lucolimac.aluvery.sample.sampleSections
import br.com.lucolimac.aluvery.ui.components.ProductsSection
import br.com.lucolimac.aluvery.ui.theme.Dimen
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen8

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(sections: Map<String, List<Product>>) {
    Column {
        var imputedText by remember { mutableStateOf("") }
        OutlinedTextField(value = imputedText,
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
            modifier = Modifier
                .padding(Dimen8)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Produto") },
            placeholder = { Text(text = "O que você está prucurando?") },
            onValueChange = {
                imputedText = it
            })
        LazyColumn(
            modifier = Modifier.padding(horizontal = Dimen.Dimen16),
            verticalArrangement = Arrangement.spacedBy(Dimen.Dimen16),
            contentPadding = PaddingValues(vertical = Dimen.Dimen16),
        ) {
            sections.forEach {
                item {
                    ProductsSection(section = Section(it.key, it.value))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(sampleSections)
}