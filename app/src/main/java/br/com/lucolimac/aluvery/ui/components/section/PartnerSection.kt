package br.com.lucolimac.aluvery.ui.components.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import br.com.lucolimac.aluvery.domain.entity.PartnerSectionData
import br.com.lucolimac.aluvery.ui.components.Partner
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen16

@Composable
fun PartnersSection(
    partnerSectionData: PartnerSectionData, modifier: Modifier = Modifier
) {
    Section(title = {
        Text(
            text = partnerSectionData.title,
            Modifier.padding(
                start = Dimen16, end = Dimen16
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }, content = {
        LazyRow(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Dimen16),
            contentPadding = PaddingValues(horizontal = Dimen16)
        ) {
            items(partnerSectionData.partners) {
                Partner(shop = it)
            }
        }
    }, modifier = modifier)
}