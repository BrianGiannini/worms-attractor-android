package dev.sangui.bigwormsattractor.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object WormsTheme {
    val colors: WormsColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    @Composable
    fun BigWormsAttractorTheme(
        colors: WormsColors = if (isSystemInDarkTheme()) wormsDarkColors() else wormsLightColors(),
        content: @Composable () -> Unit
    ) {
        CompositionLocalProvider(
            LocalColors provides colors,
        ) {
            content()
        }

    }

}