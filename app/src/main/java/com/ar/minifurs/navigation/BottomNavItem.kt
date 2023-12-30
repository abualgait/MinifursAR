package com.ar.minifurs.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalTaxi
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.ar.minifurs.R


sealed class BottomNavItem(
    @StringRes var title: Int,
    var activeIcon: ImageVector,
    var inactiveIcon: ImageVector,
    var screenRoute: String
) {
    data object Dashboard : BottomNavItem(
        R.string.dashboard,
        Icons.Filled.Home,
        Icons.Filled.Home,
        BottomNavigationRoute.Dashboard.value
    )

    data object Cart : BottomNavItem(
        R.string.cart,
        Icons.Filled.ShoppingCart,
        Icons.Filled.ShoppingCart,
        BottomNavigationRoute.Cart.value
    )

    data object Favorites : BottomNavItem(
        R.string.favorites,
        Icons.Filled.Favorite,
        Icons.Filled.FavoriteBorder,
        BottomNavigationRoute.Favorites.value
    )

    data object Profile : BottomNavItem(
        R.string.profile,
        Icons.Filled.Person,
        Icons.Filled.Person,
        BottomNavigationRoute.Profile.value
    )
}