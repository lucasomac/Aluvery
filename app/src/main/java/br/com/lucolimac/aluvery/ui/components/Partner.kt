package br.com.lucolimac.aluvery.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import br.com.lucolimac.aluvery.R
import br.com.lucolimac.aluvery.domain.entity.Shop
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen100
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen150
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen200
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen8
import coil.compose.AsyncImage

@Composable
fun Partner(
    shop: Shop,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier,
    ) {
        Column(
            Modifier
                .heightIn(Dimen150, Dimen200)
                .width(Dimen100)
        ) {
            val imageSize = Dimen100
            AsyncImage(
                model = shop.logo,
                contentDescription = null,
                Modifier
                    .size(imageSize)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder)
            )
            Text(
                text = shop.name,
                modifier = Modifier
                    .padding(Dimen8)
                    .fillMaxWidth(),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
