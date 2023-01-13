package br.com.lucolimac.aluvery.ui.components.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.lucolimac.aluvery.ui.theme.Dimen.Dimen16

@Composable
fun Section(
    title: @Composable () -> Unit, content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier) {
        title()
        Spacer(modifier = Modifier.height(Dimen16))
        content()
    }
}