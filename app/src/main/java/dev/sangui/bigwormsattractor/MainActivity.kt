package dev.sangui.bigwormsattractor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dev.sangui.bigwormsattractor.ui.theme.WormsTheme
import dev.sangui.bigwormsattractor.ui.theme.WormsTheme.BigWormsAttractorTheme
import dev.sangui.bigwormsattractor.view.SandWormScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BigWormsAttractorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = WormsTheme.colors.background,
                ) {
                    SandWormScreen()
                }
            }
        }
    }
}
