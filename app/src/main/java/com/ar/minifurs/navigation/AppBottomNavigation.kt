package com.ar.minifurs.navigation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Dashboard,
        BottomNavItem.Cart,
        BottomNavItem.Favorites,
        BottomNavItem.Profile
    )
    Row(
      modifier = Modifier.background(Color.White).padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                CustomTabItem(item, currentRoute) {
                    navController.navigate(it.screenRoute) {
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        }
    }
}

@Composable
fun CustomTabItem(item: BottomNavItem, currentRoute: String?, onClick: (BottomNavItem) -> Unit) {

    val color = if (currentRoute == item.screenRoute) {
        MaterialTheme.colors.primary
    } else {
        Color(0xFFAAAAAA)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            onClick(item)
        }) {
        Crossfade(
            targetState = currentRoute == item.screenRoute,
            label = ""
        ) { isChecked ->
            val iconPainter = if (isChecked) {
                item.activeIcon
            } else {
                item.inactiveIcon
            }
            Icon(
                imageVector = iconPainter,
                contentDescription = stringResource(id = item.title),
                tint = color,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(3.dp))
        Box(
            modifier = Modifier
                .size(4.dp)
                .clip(CircleShape)
                .background(
                    color
                )

        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = stringResource(id = item.title),
            style = TextStyle(
                fontSize = 8.sp,
                fontWeight = FontWeight(400),
                color = color,
            )
        )

    }
}
