package com.ar.minifurs.navigation

enum class Route(val value: String) {
    MainActivity("mainActivity"),
    ProductDetails("ProductDetails/{id}"),
    ARView("ARView/{id}")
}

enum class BottomNavigationRoute(val value: String) {
    BottomNavigation("BottomNavigation"),
    Dashboard("dashboard"),
    Cart("cart"),
    Favorites("favorites"),
    Profile("profile")
}