package br.com.lucolimac.aluvery.ui.components.product

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import br.com.lucolimac.aluvery.R
import br.com.lucolimac.aluvery.domain.entity.Product
import br.com.lucolimac.aluvery.sample.sampleProducts
import br.com.lucolimac.aluvery.ui.theme.AluveryTheme
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen100
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen150
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen16
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen4
import br.com.lucolimac.aluvery.utils.Extensions.toBrazilianCurrency
import coil.compose.AsyncImage

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = Dimen4,
    isExpanded: Boolean = false
) {
    var expanded by rememberSaveable { mutableStateOf(isExpanded) }
    Card(
        modifier
            .fillMaxWidth()
            .heightIn(Dimen150)
            .clickable { expanded = !expanded },
        elevation = CardDefaults.cardElevation(elevation)
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(Dimen100),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .padding(Dimen16)
            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toBrazilianCurrency()
                )
            }
            if (expanded) {
                product.description?.let {
                    Text(
                        text = it,
                        Modifier.padding(Dimen16),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = sampleProducts.random(),
            )
        }
    }
}