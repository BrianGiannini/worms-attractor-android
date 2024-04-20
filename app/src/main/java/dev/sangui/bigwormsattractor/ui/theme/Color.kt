package dev.sangui.bigwormsattractor.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class WormsColors(
    val background: Color,
)

fun wormsLightColors(
    background: Color = Color(0xFF, 0xF9, 0xC8),
): WormsColors = WormsColors(
    background = background,
)

fun wormsDarkColors(
    background: Color = Color(255, 204, 0),
): WormsColors = WormsColors(
    background = background,
)

val LocalColors = staticCompositionLocalOf { wormsDarkColors() }