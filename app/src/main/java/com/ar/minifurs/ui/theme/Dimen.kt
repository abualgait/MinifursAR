package com.ar.minifurs.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Dimensions(
    val peekHeight: Dp,
    val backLayerHeight: Float,

    )

val smallDimensions = Dimensions(
    peekHeight = 160.dp,
    backLayerHeight = 0.6f,

    )

val sw360Dimensions = Dimensions(
    peekHeight = 200.dp,
    backLayerHeight = 0.4f
)

@Composable
fun ProvideDimens(
    dimensions: Dimensions,
    content: @Composable () -> Unit
) {
    val dimensionSet = remember { dimensions }
    CompositionLocalProvider(LocalAppDimens provides dimensionSet, content = content)
}

val LocalAppDimens = staticCompositionLocalOf {
    smallDimensions
}