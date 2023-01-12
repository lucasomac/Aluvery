package br.com.lucolimac.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.lucolimac.aluvery.sample.sampleSections
import br.com.lucolimac.aluvery.ui.components.AluveryApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryApp(
                sampleSections
            )
        }
    }
}
