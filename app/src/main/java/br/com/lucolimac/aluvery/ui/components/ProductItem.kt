package br.com.lucolimac.aluvery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.lucolimac.aluvery.R
import br.com.lucolimac.aluvery.domain.entity.Product
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen100
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen16
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen200
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen250
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen300
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen8
import coil.compose.AsyncImage
import java.math.BigDecimal

@Composable
fun ProductItem(product: Product, modifier: Modifier = Modifier) {
    Surface(
        modifier,
        shape = RoundedCornerShape(Dimen16),
        shadowElevation = Dimen8,
    ) {
        Column(
            Modifier
                .heightIn(Dimen250, Dimen300)
                .width(Dimen200)
        ) {
            val imageSize = Dimen100
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        )
                    )
            ) {
                AsyncImage(
                    model = product.image,
                    placeholder = painterResource(id = R.drawable.placeholder),
                    contentDescription = "Imagem do produto",
                    modifier = Modifier
                        .offset(y = imageSize / 2)
                        .size(imageSize)
                        .clip(shape = CircleShape)
                        .align(alignment = BottomCenter),
                    contentScale = ContentScale.Crop
                )

            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(
                modifier = Modifier.padding(Dimen16)
            ) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily.SansSerif,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.priceFormatted,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.padding(top = Dimen8)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ProductItem(Product("Hamburguer", BigDecimal(14.50), "https://picsum.photos/200/300"))
}