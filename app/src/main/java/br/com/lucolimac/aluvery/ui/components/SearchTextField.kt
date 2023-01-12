package br.com.lucolimac.aluvery.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import br.com.lucolimac.aluvery.ui.theme.Dimen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(searchText: String, doSearchOnTextChange: (String) -> Unit) {
    OutlinedTextField(
        value = searchText,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search, contentDescription = "ícone de lupa"
            )
        },
        modifier = Modifier
            .padding(Dimen.Dimen16)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "Produto") },
        placeholder = { Text(text = "O que você procura?") },
        onValueChange = {
            doSearchOnTextChange(it)
        },
        shape = RoundedCornerShape(50)
    )
}