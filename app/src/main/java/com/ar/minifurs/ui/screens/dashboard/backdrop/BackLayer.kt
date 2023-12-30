package com.ar.minifurs.ui.screens.dashboard.backdrop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.MotionLayout
import com.ar.minifurs.R
import com.ar.minifurs.ui.motionscene.ViewRef
import com.ar.minifurs.ui.motionscene.dashboardMotionScene
import com.ar.minifurs.ui.theme.AppTheme

@Composable
fun BackLayer(progress: Float) {

    Box(
        modifier = Modifier
            .fillMaxHeight(AppTheme.dimens.backLayerHeight)
            .fillMaxWidth()
    ) {
        MotionLayout(
            dashboardMotionScene(),
            progress = progress,
            Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {
            val fontSize = customFontSize(ViewRef.Title.name, "textSize")
            Image(
                painter = painterResource(R.drawable.dashboard_bg),
                contentDescription = "dashboard_bg",
                modifier = Modifier
                    .fillMaxSize()
                    .layoutId(ViewRef.Image),
                contentScale = ContentScale.Crop
            )

            Box(

                modifier = Modifier
                    .fillMaxSize()
                    .layoutId(ViewRef.Overlay)
                    .background(
                        brush = Brush.linearGradient(
                            listOf(
                                Color(0x8200332B),
                                Color(0xB008443B)
                            )
                        )
                    ),

                )

            Box(

                modifier = Modifier
                    .height(30.dp)
                    .background(
                        shape = RoundedCornerShape(topEnd = 25.dp, topStart = 25.dp),
                        color = MaterialTheme.colors.background
                    )
                    .fillMaxWidth()
                    .layoutId(ViewRef.RoundShape)

            )

            Text(
                text = "Set up your space easily",
                modifier = Modifier
                    .layoutId(ViewRef.Title.name),
                fontSize = fontSize,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .layoutId(ViewRef.SearchBar.name)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "")
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Search Item",
                    modifier = Modifier,
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.Light,
                    fontSize = 10.sp
                )
            }
        }
    }
}

