package com.ar.minifurs.ui.screens.dashboard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.ar.minifurs.data.Product
import com.ar.minifurs.ui.screens.dashboard.backdrop.BackLayer
import com.ar.minifurs.ui.screens.dashboard.backdrop.FrontLayer
import com.ar.minifurs.ui.theme.AppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DashboardScreen(onClick: (Product) -> Unit = {}) {
    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed)
    val progress = if (scaffoldState.progress.to != BackdropValue.Revealed) {
        scaffoldState.progress.fraction
    } else {
        1f - scaffoldState.progress.fraction
    }
    BackdropScaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState,
        appBar = {
        },
        peekHeight = AppTheme.dimens.peekHeight,
        backLayerContent = {
            BackLayer(progress = progress)
        },
        backLayerBackgroundColor = Color.Transparent,
        frontLayerShape = RectangleShape,
        frontLayerBackgroundColor = Color.Transparent,
        frontLayerScrimColor = Color.Unspecified,
        frontLayerElevation = 0.dp,
        frontLayerContent = {
            FrontLayer(onClick = onClick)
        }
    )
}